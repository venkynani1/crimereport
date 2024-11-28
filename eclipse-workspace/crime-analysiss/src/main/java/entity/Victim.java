package entity;

public class Victim {
    private int victimID;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String contactInfo;

    public Victim() {}

    public Victim(int victimID, String name, int age, String gender, String address, String contactInfo) {
        this.victimID = victimID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public int getVictimID() { return victimID; }
    public void setVictimID(int victimID) { this.victimID = victimID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
