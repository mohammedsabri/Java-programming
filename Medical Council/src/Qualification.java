public class Qualification {

    private String degreeType;
    private String degreeName;
    private String college;
    private String conferringYear;

    // Constructor for objects of class Doctor
    public Qualification(String degreeType, String degreeName, String college, String conferringYear) {
        this.degreeType = degreeType;
        this.degreeName = degreeName;
        this.college = college;
        this.conferringYear = conferringYear;
    }

    //-------
    //getters
    //-------

    /**
     * Returns the DegreeType
     */
    public String getDegreeType() {
        return degreeType;
    }

    /**
     * Returns the DegreeName
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * Returns the  college
     */
    public String getCollege() {
        return college;
    }

    /**
     * Returns the conferringYear
     */
    public String getConferringYear() {
        return conferringYear;
    }


    //-------
    //setters
    //-------

    /**
     * Updates the degreeType to the value passed as a parameter
     */
    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    /**
     * Updates the degreeName to the value passed as a parameter
     */
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
    /**
     * Updates the college to the value passed as a parameter
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * Updates the conferringYear to the value passed as a parameter
     */
    public void setConferringYear(String conferringYear) {
        this.conferringYear = conferringYear;
    }


    /**
     * Builds a String representing a user friendly representation of the object state
     * @return Details of the specific Doctor
     */
    @Override
    public String toString() {
        return "Qualification{" +
                "degreeType ='" + degreeType + '\'' +
                ", degreeName ='" + degreeName + '\'' +
                ", college ='" + college + '\'' +
                ", conferringYear ='" + conferringYear + '\'' +
                '}';
    }
}


