import java.util.ArrayList;


public abstract class RegisteredDoctor extends Doctor{

    private boolean qualifiedInIreland;
    // Constructor for objects of class Doctor
    public RegisteredDoctor(String name, String dob, char gender, String address, String contactNumber, boolean qualifiedInIreland, ArrayList<Qualification> qualification) {
        super(name, dob, gender, address, contactNumber, qualification);
        this.qualifiedInIreland = qualifiedInIreland;
    }
    /**
     * Returns the DegreeType
     */
    public boolean isQualifiedInIreland() {
        this.qualifiedInIreland = qualifiedInIreland;
        return true;
    }
    /**
     * Returns the DegreeType
     */
    public void setQualifiedInIreland(boolean qualifiedInIreland) {
        this.qualifiedInIreland = qualifiedInIreland;
    }

    @Override
    public String toString() {
        return "RegisteredDoctor{" +
                "qualifiedInIreland=" + qualifiedInIreland +
                '}';
    }

}
