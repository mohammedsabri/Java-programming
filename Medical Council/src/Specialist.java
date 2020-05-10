import java.util.ArrayList;
import java.util.HashSet;

public class Specialist extends RegisteredDoctor{

    private HashSet<String> specialism;

    // Constructor for objects of class Doctor
    public Specialist(String name, String dob, char gender, String address, String contactNumber, boolean qualifiedInIreland, ArrayList<Qualification> qualification, HashSet<String> specialism) {
        super(name, dob, gender, address, contactNumber, qualifiedInIreland, qualification);
        this.specialism = specialism;
    }
    /**
     * Returns the DegreeType
     */
    public double calcRegistrationFee() {
        return calcRegistrationFee();
    }
    /**
     * Returns the DegreeType
     */
    public String viewContactDetails(){
        return super.viewContactDetails();
    }




    public HashSet<String> getSpecialism() {
        return specialism;
    }

    public void setSpecialism(HashSet<String> specialism) {
        this.specialism = specialism;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "specialism='" + specialism + '\'' +
                '}';
    }
}

