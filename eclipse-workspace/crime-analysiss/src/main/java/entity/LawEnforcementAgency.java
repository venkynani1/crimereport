package entity;

public class LawEnforcementAgency {
    private int agencyID;
    private String name;
    private String address;
    private String contactInfo;
    private String jurisdiction;

    public LawEnforcementAgency() {}

    public LawEnforcementAgency(int agencyID, String name, String address, String contactInfo, String jurisdiction) {
        this.agencyID = agencyID;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.jurisdiction = jurisdiction;
    }

    public int getAgencyID() { return agencyID; }
    public void setAgencyID(int agencyID) { this.agencyID = agencyID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getJurisdiction() { return jurisdiction; }
    public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }
}
