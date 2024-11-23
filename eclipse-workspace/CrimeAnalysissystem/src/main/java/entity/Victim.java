package entity;

public class Victim {
    private int victimID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactInformation;

    // Default Constructor
    public Victim() {}

    // Parameterized Constructor
    public Victim(int victimID, String firstName, String lastName, String dateOfBirth,
                  String gender, String contactInformation) {
        this.victimID = victimID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInformation = contactInformation;
    }

    // Getters and Setters for each field
    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    // ToString Method
    @Override
    public String toString() {
        return "Victim{" +
                "victimID=" + victimID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                '}';
    }
}
