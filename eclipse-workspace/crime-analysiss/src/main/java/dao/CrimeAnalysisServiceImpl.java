package dao;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.text.ParseException;
import java.util.InputMismatchException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import entity.Incident;
import excepetions.DateParsingException;
import excepetions.DatabaseConnectionException;
import excepetions.IncidentNumberNotFoundException;
import excepetions.CustomInputMismatchException;
import util.DBConnection;

public class CrimeAnalysisServiceImpl implements ICrimeAnalysisService {
    // Assuming DBConnection.getConnection() is being handled elsewhere, but here we initialize it statically for reuse.
    private static Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the connection failure appropriately.
        }
    }

    @Override
    public boolean createIncident(Incident incident) {
        try {
            String query = "INSERT INTO incidents (IncidentID, IncidentType, IncidentDate, Location, Descriptions, Statuss) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            // Convert String to Date
            String incidentDateString = incident.getIncidentDate();  // Assuming it's a String
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date incidentDate = dateFormat.parse(incidentDateString);
            
            // Now you can safely use incidentDate and set it to the PreparedStatement
            ps.setInt(1, incident.getIncidentID());
            ps.setString(2, incident.getIncidentType());
            ps.setDate(3, new java.sql.Date(incidentDate.getTime()));  // Using getTime() on Date object
            ps.setString(4, incident.getLocation());
            ps.setString(5, incident.getDescription());
            ps.setString(6, incident.getStatus());
            
            return ps.executeUpdate() > 0;
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the case where date format is incorrect
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return false;  // Handle input mismatch error here
        }
    }


    @Override
    public boolean updateIncidentStatus(int incidentID, String status) {
        try {
            String query = "UPDATE incidents SET Statuss = ? WHERE IncidentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, incidentID);
            return ps.executeUpdate() > 0;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return false;  // Handle input mismatch error here
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Collection<Incident> getIncidentsInDateRange(String startDate, String endDate) {
        Collection<Incident> incidents = new ArrayList<>();
        try {
            String query = "SELECT * FROM incidents WHERE IncidentDate BETWEEN ? AND ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                incidents.add(new Incident(
                        rs.getInt("IncidentID"),
                        rs.getString("IncidentType"),
                        rs.getString("IncidentDate"),
                        rs.getString("Location"),
                        rs.getString("Descriptions"),
                        rs.getString("Statuss")));
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();  // Handle input mismatch error here
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incidents;
    }

    @Override
    public Collection<Incident> searchIncidents(String incidentType) throws DatabaseConnectionException {
        Collection<Incident> incidents = new ArrayList<>();
        
        String query = "SELECT * FROM incidents WHERE IncidentType = ?";
        
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, incidentType);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int incidentID = resultSet.getInt("IncidentID");
                String type = resultSet.getString("IncidentType");
                String date = resultSet.getString("IncidentDate");
                String location = resultSet.getString("Location");
                String description = resultSet.getString("Descriptions");
                String status = resultSet.getString("Statuss");
                
                Incident incident = new Incident(incidentID, type, date, location, description, status);
                incidents.add(incident);
            }
            
            // If no incidents are found, throw an exception
            if (incidents.isEmpty()) {
                throw new IncidentNumberNotFoundException("No incidents found for the given type: " + incidentType);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException("Error while connecting to the database.");
        } catch (IncidentNumberNotFoundException e) {
            // Handle the custom exception locally
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            e.printStackTrace();  // Handle input mismatch error here
        }
        
        return incidents;
    }



    @Override
    public String generateIncidentReport(int incidentID) throws IncidentNumberNotFoundException, DatabaseConnectionException {
        String query = "SELECT * FROM incidents WHERE IncidentID = ?";
        StringBuilder report = new StringBuilder();
        
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, incidentID);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String incidentType = resultSet.getString("IncidentType");
                String incidentDate = resultSet.getString("IncidentDate");
                String location = resultSet.getString("Location");
                String description = resultSet.getString("Descriptions");
                String status = resultSet.getString("Statuss");
                int victimID = resultSet.getInt("VictimID");
                int suspectID = resultSet.getInt("SuspectID");
                
                report.append("Incident Report\n");
                report.append("----------------\n");
                report.append("Incident ID: ").append(incidentID).append("\n");
                report.append("Type: ").append(incidentType).append("\n");
                report.append("Date: ").append(incidentDate).append("\n");
                report.append("Location: ").append(location).append("\n");
                report.append("Description: ").append(description).append("\n");
                report.append("Status: ").append(status).append("\n");
                report.append("Victim ID: ").append(victimID).append("\n");
                report.append("Suspect ID: ").append(suspectID).append("\n");
            } else {
                throw new IncidentNumberNotFoundException("No incident found with ID: " + incidentID);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException("Error while connecting to the database.");
        } catch (InputMismatchException e) {
            e.printStackTrace();  // Handle input mismatch error here
        }
        
        return report.toString();
    }

}
