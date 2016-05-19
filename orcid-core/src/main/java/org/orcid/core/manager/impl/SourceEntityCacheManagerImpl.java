/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.core.manager.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.orcid.core.manager.ClientDetailsEntityCacheManager;
import org.orcid.core.manager.ProfileEntityCacheManager;
import org.orcid.jaxb.model.clientgroup.ClientType;
import org.orcid.persistence.jpa.entities.BaseEntity;
import org.orcid.persistence.jpa.entities.ClientDetailsEntity;
import org.orcid.persistence.jpa.entities.ProfileEntity;
import org.orcid.persistence.jpa.entities.SourceEntity;
import org.orcid.persistence.manager.cache.EntityCacheManager;
import org.orcid.persistence.manager.cache.SourceEntityCacheManager;
import org.orcid.utils.ReleaseNameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * @author Angel Montenegro
 * */
public class SourceEntityCacheManagerImpl implements SourceEntityCacheManager {

    @Resource
    private ProfileEntityCacheManager profileEntityCacheManager;
    
    @Resource
    private ClientDetailsEntityCacheManager clientDetailsEntityCacheManager;

    LockerObjectsManager pubLocks = new LockerObjectsManager();

    @Resource(name = "sourceEntityCache")
    private Cache sourceEntityCache;

    LockerObjectsManager lockers = new LockerObjectsManager();

    private String releaseName = ReleaseNameUtils.getReleaseName();

    private static final Logger LOG = LoggerFactory.getLogger(SourceEntityCacheManagerImpl.class);
    
    public void setProfileEntityCacheManager(EntityCacheManager entityCacheManager) {
        if(entityCacheManager instanceof ProfileEntityCacheManager) {
            this.profileEntityCacheManager = (ProfileEntityCacheManager) profileEntityCacheManager;
        }
    }

    public void setClientDetailsEntityCacheManager(EntityCacheManager entityCacheManager) {
        if(entityCacheManager instanceof ClientDetailsEntityCacheManager) {
            this.clientDetailsEntityCacheManager = (ClientDetailsEntityCacheManager) clientDetailsEntityCacheManager;
        }
    }

    @Override
    @Transactional
    public SourceEntity retrieve(String id) throws IllegalArgumentException {
        Object key = new OrcidCacheKey(id, releaseName);
        Date dbDate = retrieveLastModifiedDate(id);
        SourceEntity sourceEntity = toSourceEntity(sourceEntityCache.get(key));
        if (needsFresh(dbDate, sourceEntity))
            try {
                synchronized (lockers.obtainLock(id)) {
                    sourceEntity = toSourceEntity(sourceEntityCache.get(key));
                    if (needsFresh(dbDate, sourceEntity)) {
                        BaseEntity<String> entity = getEntity(id);
                        if(entity == null)
                            throw new IllegalArgumentException("Invalid source " + id);  
                        if(sourceEntity == null) {
                            sourceEntity = new SourceEntity();
                        }
                        
                        if(entity instanceof ClientDetailsEntity) {
                            sourceEntity.setSourceClient((ClientDetailsEntity) entity);
                        } else {
                            sourceEntity.setSourceProfile((ProfileEntity) entity);
                        }                            
                        
                        sourceEntityCache.put(new Element(key, sourceEntity));
                    }
                }
            } finally {
                lockers.releaseLock(id);
            }
        return sourceEntity;
    }

    @Override
    public void put(SourceEntity entity) {
        put(entity.getSourceId(), entity);
    }
    public void put(String id, SourceEntity entity) {
        try {
            synchronized (lockers.obtainLock(id)) {
                sourceEntityCache.put(new Element(new OrcidCacheKey(id, releaseName), entity));
            }
        } finally {
            lockers.releaseLock(id);
        }
    }

    @Override
    public void removeAll() {
        sourceEntityCache.removeAll();
    }

    @Override
    public void remove(String id) {
        sourceEntityCache.remove(new OrcidCacheKey(id, releaseName));
    }
    
    private SourceEntity toSourceEntity(Element element) {
        return (SourceEntity) (element != null ? element.getObjectValue() : null);
    }
    
    private BaseEntity<String> getEntity(String id) {
        BaseEntity<String> result = null;
        //First look for the entity in the client_details table
        try {
            ClientDetailsEntity clientDetails = clientDetailsEntityCacheManager.retrieve(id);
            //If it is a public client, we should look again in the profile table, since the public client should not be a source for anything
            if(ClientType.PUBLIC_CLIENT.equals(clientDetails.getClientType())) {
                ProfileEntity profile = profileEntityCacheManager.retrieve(id);
                result = (BaseEntity<String>) profile;
                return result;
            } else {
                result = (BaseEntity<String>) clientDetails;
            }            
        } catch(IllegalArgumentException e) {
            //If it is not there, it means the source belongs to a record, so, fetch it from the profile table
            ProfileEntity profile = profileEntityCacheManager.retrieve(id);
            result = (BaseEntity<String>) profile;
        }
        return result;
    }
    
    private Date retrieveLastModifiedDate(String id) {
        Date lastModified = null;
        //Try to fetch the last modified from the client_details table
        try {
            ClientDetailsEntity clientDetails = clientDetailsEntityCacheManager.retrieve(id);
            //If it is a public client, we should look again in the profile table, since the public client should not be a source for anything
            if(ClientType.PUBLIC_CLIENT.equals(clientDetails.getClientType())) {
                ProfileEntity profile = profileEntityCacheManager.retrieve(id);
                lastModified = profile.getLastModified();
            } else {
                lastModified = clientDetails.getLastModified();
            }            
        } catch(IllegalArgumentException e) {
            //If it is not there, it means the source belongs to a record, so, fetch it from the profile table
            ProfileEntity profile = profileEntityCacheManager.retrieve(id);
            lastModified = profile.getLastModified();
        }
        
        if(lastModified == null) {
            LOG.debug("Unable to find last modified for:" + id);   
        }
        
        return lastModified;
    }
    
    static public boolean needsFresh(Date dbDate, SourceEntity entity) {
        if (entity == null || (entity.getSourceClient() == null && entity.getSourceProfile() == null))
            return true;
        if (dbDate == null) // is this possible?
            return true;
        Date lastModified = entity.getSourceClient() == null ? entity.getSourceProfile().getLastModified() : entity.getSourceClient().getLastModified();
        if (lastModified.getTime() != dbDate.getTime())
            return true;
        return false;
    }
}