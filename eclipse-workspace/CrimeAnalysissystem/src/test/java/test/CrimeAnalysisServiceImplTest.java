package test;

import dao.CrimeAnalysisServiceImpl;
import entity.Incident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

public class CrimeAnalysisServiceImplTest {

    private CrimeAnalysisServiceImpl crimeService;

    @BeforeEach
    public void setUp() {
        // Create an instance of the CrimeAnalysisServiceImpl class
        crimeService = new CrimeAnalysisServiceImpl();
    }

    @Test
    public void testCreateIncident() {
        // Create a mock incident
        Incident incident = new Incident(
            0, "Theft", new Date(System.currentTimeMillis()), "Street", 
            "Stolen Wallet", "Reported", 1, 2, 3
        );

        // Test the createIncident method
        boolean result = crimeService.createIncident(incident);

        // Assert that the incident creation was successful (this would depend on your DB)
        assertTrue(result, "Incident should be created successfully.");
    }
}
