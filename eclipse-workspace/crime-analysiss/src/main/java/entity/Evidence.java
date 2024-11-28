package entity;

public class Evidence {
    private int evidenceID;
    private String type;
    private String description;
    private String collectedDate;
    private int incidentID;

    public Evidence() {}

    public Evidence(int evidenceID, String type, String description, String collectedDate, int incidentID) {
        this.evidenceID = evidenceID;
        this.type = type;
        this.description = description;
        this.collectedDate = collectedDate;
        this.incidentID = incidentID;
    }

    public int getEvidenceID() { return evidenceID; }
    public void setEvidenceID(int evidenceID) { this.evidenceID = evidenceID; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCollectedDate() { return collectedDate; }
    public void setCollectedDate(String collectedDate) { this.collectedDate = collectedDate; }

    public int getIncidentID() { return incidentID; }
    public void setIncidentID(int incidentID) { this.incidentID = incidentID; }
}
