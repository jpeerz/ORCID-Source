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
package org.orcid.persistence.dao.impl;

import javax.persistence.Query;

import org.orcid.persistence.dao.NameDao;
import org.orcid.persistence.jpa.entities.RecordNameEntity;

public class NameDaoImpl extends GenericDaoImpl<RecordNameEntity, Long> implements NameDao {

    public NameDaoImpl() {
        super(RecordNameEntity.class);
    }

    @Override
    public RecordNameEntity getName(String orcid) {
        Query query = entityManager.createQuery("FROM NameEntity WHERE orcid=:orcid");
        query.setParameter("orcid", orcid);
        return (RecordNameEntity) query.getSingleResult();
    }
}