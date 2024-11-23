package dao;

import entity.Incident;
import entity.Report;
import util.DBConnection;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CrimeAnalysisServiceImpl implements ICrimeAnalysisService {

    private Connection connection;

    // Constructor to initialize the database connection
    public CrimeAnalysisServiceImpl() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public boolean createIncident(Incident incident) {
        String query = "INSERT INTO Incidents (IncidentType, IncidentDate, Location, Description, Status, VictimID, SuspectID, OfficerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, incident.getIncidentType());
            stmt.setDate(2, new java.sql.Date(incident.getIncidentDate().getTime()));
            stmt.setString(3, incident.getLocation());
            stmt.setString(4, incident.getDescription());
            stmt.setString(5, incident.getStatus());
            stmt.setInt(6, incident.getVictimID());
            stmt.setInt(7, incident.getSuspectID());
            stmt.setInt(8, incident.getOfficerID());

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateIncidentStatus(String status, int incidentID) {
        String query = "UPDATE Incidents SET Status = ? WHERE IncidentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, incidentID);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Incident getIncidentById(int incidentID) {
        String query = "SELECT * FROM Incidents WHERE IncidentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, incidentID);
            
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Incident(
                        resultSet.getInt("IncidentID"),
                        resultSet.getString("IncidentType"),
                        resultSet.getDate("IncidentDate"),
                        resultSet.getString("Location"),
                        resultSet.getString("Description"),
                        resultSet.getString("Status"),
                        resultSet.getInt("VictimID"),
                        resultSet.getInt("SuspectID"),
                        resultSet.getInt("OfficerID")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // If no incident is found with the given ID
    }


    @Override
    public Collection<Incident> getIncidentsInDateRange(Date startDate, Date endDate) {
        List<Incident> incidents = new ArrayList<>();
        String query = "SELECT * FROM Incidents WHERE IncidentDate BETWEEN ? AND ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Incident incident = new Incident(
                        resultSet.getInt("IncidentID"),
                        resultSet.getString("IncidentType"),
                        resultSet.getDate("IncidentDate"),
                        resultSet.getString("Location"),
                        resultSet.getString("Description"),
                        resultSet.getString("Status"),
                        resultSet.getInt("VictimID"),
                        resultSet.getInt("SuspectID"),
                        resultSet.getInt("OfficerID")
                    );
                    incidents.add(incident);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return incidents;
    }

    @Override
    public Collection<Incident> searchIncidents(String incidentType) {
        List<Incident> incidents = new ArrayList<>();
        String query = "SELECT * FROM Incidents WHERE IncidentType = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, incidentType);

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Incident incident = new Incident(
                        resultSet.getInt("IncidentID"),
                        resultSet.getString("IncidentType"),
                        resultSet.getDate("IncidentDate"),
                        resultSet.getString("Location"),
                        resultSet.getString("Description"),
                        resultSet.getString("Status"),
                        resultSet.getInt("VictimID"),
                        resultSet.getInt("SuspectID"),
                        resultSet.getInt("OfficerID")
                    );
                    incidents.add(incident);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return incidents;
    }

    @Override
    public Report generateIncidentReport(Incident incident) {
        String query = "INSERT INTO Reports (IncidentID, ReportingOfficer, ReportDate, ReportDetails, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, incident.getIncidentID());
            stmt.setInt(2, incident.getOfficerID());  // Assuming the officer ID is provided with the incident
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(4, "Incident details report."); // Placeholder report details
            stmt.setString(5, "Draft");

            int result = stmt.executeUpdate();
            if (result > 0) {
                // Retrieve the generated report from the database
                try (Statement stmtSelect = connection.createStatement()) {
                    String selectQuery = "SELECT * FROM Reports WHERE IncidentID = " + incident.getIncidentID() + " ORDER BY ReportID DESC LIMIT 1";
                    try (ResultSet rs = stmtSelect.executeQuery(selectQuery)) {
                        if (rs.next()) {
                            return new Report(
                                rs.getInt("ReportID"),
                                rs.getInt("IncidentID"),
                                rs.getInt("ReportingOfficer"),
                                rs.getDate("ReportDate"),
                                rs.getString("ReportDetails"),
                                rs.getString("Status")
                            );
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	

	
}
