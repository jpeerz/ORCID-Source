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
package org.orcid.core.manager;

import java.util.List;

import org.orcid.persistence.jpa.entities.OrgDisambiguatedEntity;
import org.orcid.persistence.solr.entities.OrgDisambiguatedSolrDocument;

/**
 * 
 * @author Will Simpson
 * 
 */
public interface OrgDisambiguatedManager {

    void processOrgsForIndexing();

    void processOrgsWithIncorrectPopularity();

    OrgDisambiguatedEntity find(Long id);

    List<OrgDisambiguatedSolrDocument> searchSolrForOrgs(String query, int limit);

    List<OrgDisambiguatedSolrDocument> searchSolrForOrgs(String query, int limit, boolean fundersOnly);

}
