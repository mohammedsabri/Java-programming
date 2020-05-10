import java.util.ArrayList;

public class Intern extends Doctor {
   // Constructor for objects of class Doctor

    public Intern(String name, String dob, char gender, String address, String contactNumber, ArrayList<Qualification> qualification) {
        super(name, dob, gender, address, contactNumber, qualification);
    }

    /**
     * this method cal the registrationfee
     */
    public double calcRegistrationFee() {

        return 310.0;
    }

    /**
     *  Builds a String representing a user friendly representation of the object state
     */
    @Override
    public String toString() {

        return "Intern" + super.toString();
    }
}
