package com.hexaware.crime_analysiss;

import dao.CrimeAnalysisServiceImpl;
import entity.*;
import excepetions.DatabaseConnectionException;
import excepetions.IncidentNumberNotFoundException;
import excepetions.CustomInputMismatchException;  // Import the custom exception

import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomInputMismatchException {
        Scanner scanner = new Scanner(System.in);
        CrimeAnalysisServiceImpl service = new CrimeAnalysisServiceImpl(); // Service instance

        System.out.println("=== Welcome to the Crime Analysis and Reporting System (C.A.R.S.) ===");

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Create Incident");
                System.out.println("2. Update Incident Status");
                System.out.println("3. View Incidents in Date Range");
                System.out.println("4. Search Incidents by Type");
                System.out.println("5. Generate Incident Report");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Logic for creating an incident
                        System.out.println("Enter Incident Details:");
                        System.out.print("Incident Type: ");
                        String type = scanner.nextLine();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Location: ");
                        String location = scanner.nextLine();
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Status: ");
                        String status = scanner.nextLine();

                        Incident incident = new Incident(0, type, date, location, description, status);
                        if (service.createIncident(incident)) {
                            System.out.println("Incident created successfully!");
                        } else {
                            System.out.println("Failed to create incident.");
                        }
                        break;

                    case 2:
                        // Logic for updating incident status
                        System.out.print("Enter Incident ID: ");
                        int incidentId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter New Status: ");
                        String newStatus = scanner.nextLine();

                        if (service.updateIncidentStatus(incidentId, newStatus)) {
                            System.out.println("Incident status updated successfully!");
                        } else {
                            System.out.println("Failed to update incident status.");
                        }
                        break;

                    case 3:
                        // Logic for viewing incidents in a date range
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        String startDate = scanner.nextLine();
                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        String endDate = scanner.nextLine();

                        Collection<Incident> incidents = service.getIncidentsInDateRange(startDate, endDate);
                        incidents.forEach(System.out::println);
                        break;

                    case 4:
                        // Logic for searching incidents by type
                        System.out.print("Enter Incident Type: ");
                        String searchType = scanner.nextLine();

                        Collection<Incident> searchedIncidents = service.searchIncidents(searchType);
                        searchedIncidents.forEach(System.out::println);
                        break;

                    case 5:
                        // Logic for generating an incident report
                        System.out.print("Enter Incident ID: ");
                        int reportIncidentId = scanner.nextInt();

                        String report = service.generateIncidentReport(reportIncidentId);
                        if (report != null) {
                            System.out.println(report);
                        } else {
                            System.out.println("Failed to generate report.");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                // Handle the InputMismatchException by throwing the custom exception
                try {
                    throw new CustomInputMismatchException("Invalid input type entered. Please enter valid data.");
                } catch (CustomInputMismatchException customEx) {
                    System.out.println(customEx.getMessage());  // Print custom message
                    scanner.nextLine();  // Consume the invalid input
                }
            } catch (DatabaseConnectionException | IncidentNumberNotFoundException e) {
                // Handle other exceptions
                e.printStackTrace();
            }
        }
    }
}
