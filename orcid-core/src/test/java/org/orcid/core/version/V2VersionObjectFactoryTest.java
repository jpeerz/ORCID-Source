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
package org.orcid.core.version;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.orcid.core.BaseTest;

/**
 * 
 * @author Will Simpson
 *
 */
public class V2VersionObjectFactoryTest extends BaseTest {

    @Resource
    V2VersionObjectFactory v2VersionObjectFactory;

    //WORKS
    @Test
    public void testWorkMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record_rc1.Work workRc1 = new org.orcid.jaxb.model.record_rc1.Work();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record_rc2.Work);
    }

    @Test
    public void testWorkMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record_rc1.Work workRc1 = new org.orcid.jaxb.model.record_rc1.Work();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Work);
    }
    
    @Test
    public void testWorkMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.Work workRc2 = new org.orcid.jaxb.model.record_rc2.Work();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Work);
    }

    public void testWorkSummaryMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record.summary_rc1.WorkSummary workRc1 = new org.orcid.jaxb.model.record.summary_rc1.WorkSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record.summary_rc2.WorkSummary);
    }

    @Test
    public void testWorkSummaryMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc1.WorkSummary workRc1 = new org.orcid.jaxb.model.record.summary_rc1.WorkSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.WorkSummary);
    }
    
    @Test
    public void testWorkSummaryMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc2.WorkSummary workRc2 = new org.orcid.jaxb.model.record.summary_rc2.WorkSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(workRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.WorkSummary);
    }
    
    //FUNDINGS
    @Test
    public void testFundingMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record_rc1.Funding fundingRc1 = new org.orcid.jaxb.model.record_rc1.Funding();
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record_rc2.Funding);
    }
    
    @Test
    public void testFundingMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record_rc1.Funding fundingRc1 = new org.orcid.jaxb.model.record_rc1.Funding();
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Funding);
    }
    
    @Test
    public void testFundingMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.Funding fundingRc2 = new org.orcid.jaxb.model.record_rc2.Funding();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Funding);
    }
    
    @Test
    public void testFundingSummaryMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record.summary_rc1.FundingSummary fundingSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.FundingSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingSummaryRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record.summary_rc2.FundingSummary);
    }
    
    @Test
    public void testFundingSummaryMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc1.FundingSummary fundingSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.FundingSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingSummaryRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.FundingSummary);
    }
    
    @Test
    public void testFundingSummaryMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc2.FundingSummary fundingSummaryRc2 = new org.orcid.jaxb.model.record.summary_rc2.FundingSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(fundingSummaryRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.FundingSummary);
    }
    
    //EDUCATIONS
    @Test
    public void testEducationMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record_rc1.Education educationRc1 = new org.orcid.jaxb.model.record_rc1.Education();
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record_rc2.Education);
    }
    
    @Test
    public void testEducationMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record_rc1.Education educationRc1 = new org.orcid.jaxb.model.record_rc1.Education();
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Education);
    }
    
    @Test
    public void testEducationMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.Education educationRc2 = new org.orcid.jaxb.model.record_rc2.Education();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Education);
    }
    
    @Test
    public void testEducationSummaryMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record.summary_rc1.EducationSummary educationSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.EducationSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationSummaryRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record.summary_rc2.EducationSummary);
    }
    
    @Test
    public void testEducationSummaryMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc1.EducationSummary educationSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.EducationSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationSummaryRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.EducationSummary);
    }
    
    @Test
    public void testEducationSummaryMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc2.EducationSummary educationSummaryRc2 = new org.orcid.jaxb.model.record.summary_rc2.EducationSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(educationSummaryRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.EducationSummary);
    }
    
    //EMPLOYMENTS
    @Test
    public void testEmploymentMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record_rc1.Employment employmentRc1 = new org.orcid.jaxb.model.record_rc1.Employment();
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record_rc2.Employment);
    }
    
    @Test
    public void testEmploymentMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record_rc1.Employment employmentRc1 = new org.orcid.jaxb.model.record_rc1.Employment();
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Employment);
    }
    
    @Test
    public void testEmploymentMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.Employment employmentRc2 = new org.orcid.jaxb.model.record_rc2.Employment();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Employment);
    }
    
    @Test
    public void testEmploymentSummaryMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record.summary_rc1.EmploymentSummary employmentSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.EmploymentSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentSummaryRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record.summary_rc2.EmploymentSummary);
    }
    
    @Test
    public void testEmploymentSummaryMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc1.EmploymentSummary employmentSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.EmploymentSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentSummaryRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.EmploymentSummary);
    }
    
    @Test
    public void testEmploymentSummaryMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc2.EmploymentSummary employmentSummaryRc2 = new org.orcid.jaxb.model.record.summary_rc2.EmploymentSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(employmentSummaryRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.EmploymentSummary);
    }
    
    //PEER REVIEWS
    @Test
    public void testPeerReviewMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record_rc1.PeerReview peerReviewRc1 = new org.orcid.jaxb.model.record_rc1.PeerReview();
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record_rc2.PeerReview);
    }
    
    @Test
    public void testPeerReviewMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record_rc1.PeerReview peerReviewRc1 = new org.orcid.jaxb.model.record_rc1.PeerReview();
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.PeerReview);
    }
    
    @Test
    public void testPeerReviewMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.PeerReview peerReviewRc2 = new org.orcid.jaxb.model.record_rc2.PeerReview();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.PeerReview);
    }
    
    @Test
    public void testPeerReviewSummaryMapping_rc1_to_rc2() {
        org.orcid.jaxb.model.record.summary_rc1.PeerReviewSummary peerReviewSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.PeerReviewSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewSummaryRc1, "2.0_rc2");
        assertNotNull(result);
        assertTrue("Result should be rc2", result instanceof org.orcid.jaxb.model.record.summary_rc2.PeerReviewSummary);
    }
    
    @Test
    public void testPeerReviewSummaryMapping_rc1_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc1.PeerReviewSummary peerReviewSummaryRc1 = new org.orcid.jaxb.model.record.summary_rc1.PeerReviewSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewSummaryRc1, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.PeerReviewSummary);
    }
    
    @Test
    public void testPeerReviewSummaryMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record.summary_rc2.PeerReviewSummary peerReviewSummaryRc2 = new org.orcid.jaxb.model.record.summary_rc2.PeerReviewSummary();
        Object result = v2VersionObjectFactory.createEquivalentInstance(peerReviewSummaryRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record.summary_rc3.PeerReviewSummary);
    }
    
    //OTHER NAMES
    @Test
    public void testOtherNameMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.OtherName otherNameRc2 = new org.orcid.jaxb.model.record_rc2.OtherName();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(otherNameRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.OtherName);
    }
    
    //ADDRESSES
    @Test
    public void testAddressMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.Address addressRc2 = new org.orcid.jaxb.model.record_rc2.Address();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(addressRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.Address);
    }
    
    //RESEARCHER URLS
    @Test
    public void testResearcherUrlMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.ResearcherUrl researcherUrlRc2 = new org.orcid.jaxb.model.record_rc2.ResearcherUrl();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(researcherUrlRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.ResearcherUrl);
    }
    
    //EXTERNAL IDENTIFIERS
    @Test
    public void testPersonExternalIdentifierMapping_rc2_to_rc3() {
        org.orcid.jaxb.model.record_rc2.PersonExternalIdentifier extIdRc2 = new org.orcid.jaxb.model.record_rc2.PersonExternalIdentifier();        
        Object result = v2VersionObjectFactory.createEquivalentInstance(extIdRc2, "2.0_rc3");
        assertNotNull(result);
        assertTrue("Result should be rc3", result instanceof org.orcid.jaxb.model.record_rc3.PersonExternalIdentifier);
    }
}
