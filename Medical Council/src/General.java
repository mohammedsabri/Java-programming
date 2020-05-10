import java.util.ArrayList;


public class General extends RegisteredDoctor {
    // Constructor for objects of class Doctor
    public General(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualification, boolean qualifiedInIreland) {
        super(name, dob, gender, address, contactNumber, qualifiedInIreland, qualification);
    }


    /**
     * Returns the DegreeType
     */
    public double calcRegistrationFee() {
        return calcRegistrationFee();

    }


    @Override
    public String toString() {
        return "General"  + super.toString();
    }
}

