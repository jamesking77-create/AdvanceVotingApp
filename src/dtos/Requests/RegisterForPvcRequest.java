package dtos.Requests;

public class RegisterForPvcRequest {
    private String firstName;
    private String lastName;
    private String dateRegistered;
    private String state;
    private String localDistrictArea;
    private String dateOfBirth;
    private String occupation;
    private String Gender;
    private String userId;
    private int vin;

    @Override
    public String toString() {
        return "RegisterForPvcRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateRegistered='" + dateRegistered + '\'' +
                ", state='" + state + '\'' +
                ", localDistrictArea='" + localDistrictArea + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", occupation='" + occupation + '\'' +
                ", Gender='" + Gender + '\'' +
                ", userId='" + userId + '\'' +
                ", vin=" + vin +
                '}';
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

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocalDistrictArea() {
        return localDistrictArea;
    }

    public void setLocalDistrictArea(String localDistrictArea) {
        this.localDistrictArea = localDistrictArea;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }
}
