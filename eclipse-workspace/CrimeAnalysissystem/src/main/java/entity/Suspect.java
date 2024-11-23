package entity;

public class Suspect {
    private int suspectID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactInformation;

    // Default Constructor
    public Suspect() {}

    // Parameterized Constructor
    public Suspect(int suspectID, String firstName, String lastName, String dateOfBirth,
                   String gender, String contactInformation) {
        this.suspectID = suspectID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInformation = contactInformation;
    }

    // Getters and Setters for each field
    public int getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(int suspectID) {
        this.suspectID = suspectID;
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
        return "Suspect{" +
                "suspectID=" + suspectID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                '}';
    }
}
