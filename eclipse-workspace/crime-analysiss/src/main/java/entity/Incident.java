package entity;

public class Incident {
    private int incidentID;
    private String incidentType;
    private String incidentDate;
    private String location;
    private String description;
    private String status;
    private int victimID = 0;  // Default value
    private int suspectID = 0; // Default value
    private int officerID = 0; // Default value

    // Constructor without victimID, suspectID, officerID (they will default to 0)
    public Incident(int incidentID, String incidentType, String incidentDate, String location, 
                    String description, String status) {
        this.incidentID = incidentID;
        this.incidentType = incidentType;
        this.incidentDate = incidentDate;
        this.location = location;
        this.description = description;
        this.status = status;
    }

    // Getter methods
    public int getIncidentID() {
        return incidentID;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getVictimID() {
        return victimID;
    }

    public int getSuspectID() {
        return suspectID;
    }

    public int getOfficerID() {
        return officerID;
    }
}
