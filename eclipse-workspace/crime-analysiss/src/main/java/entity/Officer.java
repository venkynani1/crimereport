package entity;

public class Officer {
    private int officerID;
    private String name;
    private String rank;
    private String contactInfo;
    private String assignedDepartment;

    public Officer() {}

    public Officer(int officerID, String name, String rank, String contactInfo, String assignedDepartment) {
        this.officerID = officerID;
        this.name = name;
        this.rank = rank;
        this.contactInfo = contactInfo;
        this.assignedDepartment = assignedDepartment;
    }

    public int getOfficerID() { return officerID; }
    public void setOfficerID(int officerID) { this.officerID = officerID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getAssignedDepartment() { return assignedDepartment; }
    public void setAssignedDepartment(String assignedDepartment) { this.assignedDepartment = assignedDepartment; }
}
