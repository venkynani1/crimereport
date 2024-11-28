package com.hexaware.crime_analysiss;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CrimeAnalysisServiceImpl;
import entity.Incident;
import excepetions.DatabaseConnectionException;
import excepetions.IncidentNumberNotFoundException;

import java.util.Collection;

class CrimeAnalysisServiceImplTest {

    private CrimeAnalysisServiceImpl crimeAnalysisService;

    @BeforeEach
    void setUp() {
        crimeAnalysisService = new CrimeAnalysisServiceImpl();
    }


    @Test
    void testCreateIncident_Failure() {
        // Prepare test data with incorrect date
        Incident incident = new Incident(2, "Robbery", "invalid-date", "Downtown", "A robbery occurred", "Investigating");
        
        // Call the method
        boolean result = crimeAnalysisService.createIncident(incident);
        
        // Assert that the incident creation fails
        assertFalse(result, "The incident creation should fail due to incorrect date format.");
    }

    @Test
    void testUpdateIncidentStatus_Success() {
        // Assuming incident with ID 1 exists in the database
        int incidentID = 1;
        String newStatus = "Solved";
        
        // Call the method
        boolean result = crimeAnalysisService.updateIncidentStatus(incidentID, newStatus);
        
        // Assert that the status is updated successfully
        assertTrue(result, "The incident status should be updated successfully.");
    }

    @Test
    void testUpdateIncidentStatus_Failure() {
        // Assuming incident with ID 999 does not exist in the database
        int incidentID = 999;
        String newStatus = "Solved";
        
        // Call the method
        boolean result = crimeAnalysisService.updateIncidentStatus(incidentID, newStatus);
        
        // Assert that the update fails
        assertFalse(result, "The incident status update should fail due to non-existent incident.");
    }

    @Test
    void testGetIncidentsInDateRange() {
        // Assuming incidents exist in the date range
        String startDate = "2024-11-01";
        String endDate = "2024-11-30";
        
        // Call the method
        Collection<Incident> incidents = crimeAnalysisService.getIncidentsInDateRange(startDate, endDate);
        
        // Assert that incidents are retrieved
        assertNotNull(incidents, "The incidents collection should not be null.");
        assertTrue(incidents.size() > 0, "The incidents collection should contain incidents.");
    }

    @Test
    void testSearchIncidents_Success() throws DatabaseConnectionException {
        // Assuming incidents of type "Robbery" exist in the database
        String incidentType = "Robbery";
        
        // Call the method
        Collection<Incident> incidents = crimeAnalysisService.searchIncidents(incidentType);
        
        // Assert that incidents are found
        assertNotNull(incidents, "The incidents collection should not be null.");
        assertTrue(incidents.size() > 0, "The incidents collection should contain incidents of the specified type.");
    }

    @Test
    void testSearchIncidents_NoResults() throws DatabaseConnectionException {
        // Assuming no incidents of type "NonExistent" in the database
        String incidentType = "NonExistent";
        
        // Call the method
        Collection<Incident> incidents = crimeAnalysisService.searchIncidents(incidentType);
        
        // Assert that no incidents are found
        assertTrue(incidents.isEmpty(), "The incidents collection should be empty for a non-existent type.");
    }

    @Test
    void testGenerateIncidentReport_Success() throws IncidentNumberNotFoundException, DatabaseConnectionException {
        // Assuming incident with ID 1 exists in the database
        int incidentID = 1;
        
        // Call the method
        String report = crimeAnalysisService.generateIncidentReport(incidentID);
        
        // Assert that the report is generated
        assertNotNull(report, "The incident report should not be null.");
        assertTrue(report.contains("Incident Report"), "The report should contain 'Incident Report'.");
    }

    @Test
    void testGenerateIncidentReport_Failure() throws IncidentNumberNotFoundException, DatabaseConnectionException {
        // Assuming incident with ID 999 does not exist in the database
        int incidentID = 999;
        
        // Call the method and assert that an exception is thrown
        assertThrows(IncidentNumberNotFoundException.class, () -> {
            crimeAnalysisService.generateIncidentReport(incidentID);
        });
    }
}
