package main;

import dao.CrimeAnalysisServiceImpl;
import entity.Incident;
import entity.Report;
import java.sql.Date;
import java.util.Collection;
import java.util.Scanner;

public class MainModule {

    // Create an instance of CrimeAnalysisServiceImpl to access database functions
    private static CrimeAnalysisServiceImpl crimeService;

    public static void main(String[] args) {
        try {
            // Initialize the crime analysis service
            crimeService = new CrimeAnalysisServiceImpl();

            // Create a scanner to get user input
            Scanner scanner = new Scanner(System.in);
            int choice;

            // Menu loop
            do {
                System.out.println("\n***** Crime Analysis and Reporting System *****");
                System.out.println("1. Create New Incident");
                System.out.println("2. Update Incident Status");
                System.out.println("3. Get Incidents in Date Range");
                System.out.println("4. Search Incidents by Type");
                System.out.println("5. Generate Report for Incident");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Option 1: Create New Incident
                        createNewIncident(scanner);
                        break;
                    case 2:
                        // Option 2: Update Incident Status
                        updateIncidentStatus(scanner);
                        break;
                    case 3:
                        // Option 3: Get Incidents in Date Range
                        getIncidentsInDateRange(scanner);
                        break;
                    case 4:
                        // Option 4: Search Incidents by Type
                        searchIncidentsByType(scanner);
                        break;
                    case 5:
                        // Option 5: Generate Report for an Incident
                        generateIncidentReport(scanner);
                        break;
                    case 6:
                        // Option 6: Exit
                        System.out.println("Exiting the system.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
            } while (choice != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to create a new incident
    private static void createNewIncident(Scanner scanner) {
        System.out.print("Enter Incident Type (e.g., Robbery, Homicide): ");
        String type = scanner.next();

        System.out.print("Enter Incident Date (YYYY-MM-DD): ");
        String date = scanner.next();
        Date incidentDate = Date.valueOf(date);

        System.out.print("Enter Incident Location: ");
        String location = scanner.next();

        System.out.print("Enter Incident Description: ");
        String description = scanner.next();

        System.out.print("Enter Status (e.g., Open, Closed): ");
        String status = scanner.next();

        System.out.print("Enter Victim ID: ");
        int victimID = scanner.nextInt();

        System.out.print("Enter Suspect ID: ");
        int suspectID = scanner.nextInt();

        System.out.print("Enter Officer ID: ");
        int officerID = scanner.nextInt();

        Incident incident = new Incident(0, type, incidentDate, location, description, status, victimID, suspectID, officerID);

        boolean isCreated = crimeService.createIncident(incident);
        if (isCreated) {
            System.out.println("Incident created successfully.");
        } else {
            System.out.println("Failed to create incident.");
        }
    }

    // Method to update incident status
    private static void updateIncidentStatus(Scanner scanner) {
        System.out.print("Enter Incident ID to update: ");
        int incidentID = scanner.nextInt();

        System.out.print("Enter new status (Open/Closed/Under Investigation): ");
        String status = scanner.next();

        boolean isUpdated = crimeService.updateIncidentStatus(status, incidentID);
        if (isUpdated) {
            System.out.println("Incident status updated successfully.");
        } else {
            System.out.println("Failed to update incident status.");
        }
    }

    // Method to get incidents in a specific date range
    private static void getIncidentsInDateRange(Scanner scanner) {
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = scanner.next();
        Date startDate = Date.valueOf(startDateStr);

        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDateStr = scanner.next();
        Date endDate = Date.valueOf(endDateStr);

        Collection<Incident> incidents = crimeService.getIncidentsInDateRange(startDate, endDate);

        if (incidents.isEmpty()) {
            System.out.println("No incidents found in this date range.");
        } else {
            System.out.println("Incidents in the given date range:");
            for (Incident incident : incidents) {
                System.out.println(incident);
            }
        }
    }

    // Method to search incidents by type (Robbery, Homicide, etc.)
    private static void searchIncidentsByType(Scanner scanner) {
        System.out.print("Enter Incident Type (e.g., Robbery, Homicide): ");
        String type = scanner.next();

        Collection<Incident> incidents = crimeService.searchIncidents(type);

        if (incidents.isEmpty()) {
            System.out.println("No incidents found of type " + type);
        } else {
            System.out.println("Incidents found of type " + type + ":");
            for (Incident incident : incidents) {
                System.out.println(incident);
            }
        }
    }

    // Method to generate a report for an incident
    private static void generateIncidentReport(Scanner scanner) {
        System.out.print("Enter Incident ID to generate report: ");
        int incidentID = scanner.nextInt();

        // Fetch the incident by ID
        Incident incident = crimeService.getIncidentById(incidentID);
        if (incident != null) {
            Report report = crimeService.generateIncidentReport(incident);
            if (report != null) {
                System.out.println("Report generated successfully: " + report);
            } else {
                System.out.println("Failed to generate report.");
            }
        } else {
            System.out.println("Incident not found.");
        }
    }
}
