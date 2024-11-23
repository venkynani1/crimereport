package dao;

import entity.Incident;
import entity.Report;

import java.sql.Date;
import java.util.Collection;

public interface ICrimeAnalysisService {

    boolean createIncident(Incident incident);

   

    Collection<Incident> searchIncidents(String incidentType);

    // Updated method to accept an Incident object
    Report generateIncidentReport(Incident incident);

	

	Boolean updateIncidentStatus(String status, int incidentID);



	Collection<Incident> getIncidentsInDateRange(Date startDate, Date endDate);



	Incident getIncidentById(int incidentID);
}
