package dao;

import java.util.Collection;

import entity.Incident;
import excepetions.DatabaseConnectionException;
import excepetions.IncidentNumberNotFoundException;

public interface ICrimeAnalysisService {
    boolean createIncident(Incident incident);
    boolean updateIncidentStatus(int incidentID, String status);
    Collection<Incident> getIncidentsInDateRange(String startDate, String endDate);
  
    
        Collection<Incident> searchIncidents(String incidentType) throws IncidentNumberNotFoundException, DatabaseConnectionException;
        String generateIncidentReport(int incidentID) throws IncidentNumberNotFoundException, DatabaseConnectionException;
    

}
