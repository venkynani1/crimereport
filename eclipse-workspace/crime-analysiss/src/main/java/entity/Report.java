package entity;

public class Report {
    private int reportID;
    private String reportType;
    private String createdDate;
    private String content;
    private int incidentID;

    public Report() {}

    public Report(int reportID, String reportType, String createdDate, String content, int incidentID) {
        this.reportID = reportID;
        this.reportType = reportType;
        this.createdDate = createdDate;
        this.content = content;
        this.incidentID = incidentID;
    }

    public int getReportID() { return reportID; }
    public void setReportID(int reportID) { this.reportID = reportID; }

    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getIncidentID() { return incidentID; }
    public void setIncidentID(int incidentID) { this.incidentID = incidentID; }
}
