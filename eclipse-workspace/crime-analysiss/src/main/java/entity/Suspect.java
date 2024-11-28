package entity;

public class Suspect {
    private int suspectID;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String criminalRecord;

    public Suspect() {}

    public Suspect(int suspectID, String name, int age, String gender, String address, String criminalRecord) {
        this.suspectID = suspectID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.criminalRecord = criminalRecord;
    }

    public int getSuspectID() { return suspectID; }
    public void setSuspectID(int suspectID) { this.suspectID = suspectID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCriminalRecord() { return criminalRecord; }
    public void setCriminalRecord(String criminalRecord) { this.criminalRecord = criminalRecord; }
}
