import java.util.ArrayList;

public abstract class Doctor implements iDoctor {
    private String name;
    private String dob;
    private char  gender;
    private String address;
    private String contactNumber;
    private ArrayList<Qualification> qualifications;

    // Constructor for objects of class Doctor
    public Doctor(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualification) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.contactNumber = contactNumber;
        this.qualifications = qualification;
    }

    public String viewContactDetails() {

        return "name " + name + " address" + address + "contactNumber" + contactNumber;
    }

    public String getFullGender() {
        if (gender == 'm' || gender == 'M') {
            return "male";
        } else if (gender == 'f' || gender == 'F') {
            return "female";
        } else {
            return "Unknown";
        }

    }
    public void addQualification(Qualification Qualified) {

        qualifications.add(Qualified);

    }


    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public ArrayList<Qualification> getQualifications() {
        return qualifications;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setQualifications(ArrayList<Qualification> qualification) {
        this.qualifications = qualification;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

