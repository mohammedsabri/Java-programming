import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import util.ScannerInput;
public class Driver {

    private Scanner sc = new Scanner(System.in);
    private DoctorAPI doctorAPI = new DoctorAPI();


    public static void main(String[] args) {
        Driver app = new Driver();
        app.run();
    }


    private int mainMenu() {
        System.out.println("1) Add a Doctor");
        System.out.println("2) List all Doctors");
        System.out.println("3) List Doctors by Name");
        System.out.println("4) Update Doctor Details");
        System.out.println("5) Update Doctor Qualifications");
        System.out.println("6) Update Doctor Specialisms");
        System.out.println("7) Delete Doctor");

        System.out.println("10) Annual Fees Report ");
        System.out.println("11) Doctor report (by category)");
        System.out.println("12) Doctor summary report");


        System.out.println("20) save from XML ");
        System.out.println("21) load to XML ");

        System.out.println("0) Exit");

        int option = ScannerInput.readNextInt("==>>");
        return option;
    }

    public void run () {

            System.out.println("Doctors");
            int option = mainMenu();
            while (option != 0) {

                switch (option) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        listallDoctors();
                        break;
                    case 3:
                       listDoctorsByname();
                        break;
                    case 4:
                        updatedoctorDetails();
                        break;
                   case 5:
                        updatedoctorQualifications();
                       break;
                    case 6:
                        updatedoctorSpecialisms();
                        break;
                    case 7:
                        deleteDoctor();
                       break;
                    case 10:
                        AnnualFeesreport();
                        break;
                    case 11:
                        DoctorreportBycategory();
                        break;
                    case 12:
                        Doctorsummaryreport();
                        break;
                    case 13:
                        try{
                            doctorAPI.save();
                        }
                        catch(Exception e){
                            System.err.println("Error writing to file: " + e);
                        }
                        break;
                    case 14:
                        try{
                            doctorAPI.load();
                        }
                        catch(Exception e){
                            System.err.println("Error writing to file: " + e);
                        }
                        break;
                    default:
                        System.out.println("Invalid option entered: " + option);
                        break;
                }

                }
                System.out.println("\nPress any key to continue....");
                sc.nextLine();
                option = mainMenu();
            }
    {
            System.out.println("Exiting... bye");


    }




    private void addDoctor() {
            System.out.println("choose a Doctor");
            System.out.println("1) Add a Intern");
            System.out.println("2) Add a Specialist");
            System.out.println("3) Add a General");

            int docType = ScannerInput.readNextInt("==>>"); //use scannerinput


            //create a message object:
            System.out.println("Please Enter the Doctor Full Name: ");
            String doctorfullname = sc.nextLine();

            System.out.println("Please Enter the Doctor date of birth : ");
            String doctordob = sc.nextLine();

            System.out.println("Please Enter the Doctor Gender : ");
            char doctorgender = sc.nextLine().charAt(0);

            System.out.println("Please Enter the Doctor Address: ");
            String doctoraddress = sc.nextLine();

            System.out.println("Please Enter the Doctor Contact Number: ");
            String contactNumber = sc.nextLine();


            int qualNum = ScannerInput.readNextInt("Please Enter how many Qualifications: ");


            ArrayList<Qualification> quArray = new ArrayList<>();
            //loop
            for (int index = 0; index < qualNum; index++) {
                System.out.println("Enter Degree Name");
                String degreename = sc.nextLine();

                System.out.println("Enter Degree Type");

                String degreetype = sc.nextLine();

                System.out.println("Enter College Name");

                String collegeName = sc.nextLine();

                System.out.println("Enter ConferringYear");

                String conferringyear = sc.nextLine();
                quArray.add(new Qualification(degreetype, degreename, collegeName, conferringyear));
            }


            if (docType == 1) {
                doctorAPI.addDoctor(new Intern(doctorfullname, doctordob, doctorgender, doctoraddress, contactNumber, quArray));
            }
            if (docType == 2) {
                System.out.println("Are u qualified in ireland");
                char qualifiedInIreland = sc.nextLine().charAt(0);
                boolean qualifiedInIrelandTF = false;
                if (qualifiedInIreland == 'Y' || qualifiedInIreland == 'y') {
                    qualifiedInIrelandTF = true;

                }

                int specNum = ScannerInput.readNextInt("Please Enter how many Specialism: ");

                HashSet<String> specHash = new HashSet<>();
                //loop
                for (int index = 0; index < specNum; index++) {
                    System.out.println("Enter specialism");
                    String specName = sc.nextLine();

                    specHash.add(specName);
                }

                doctorAPI.addDoctor(new Specialist(doctorfullname, doctordob, doctorgender, doctoraddress, contactNumber, qualifiedInIrelandTF, quArray, specHash));
            }
            if (docType == 3) {
                System.out.println("Are u qualified in ireland");
                char qualifiedInIreland = sc.nextLine().charAt(0);
                boolean qualifiedInIrelandTF = false;
                if (qualifiedInIreland == 'Y' || qualifiedInIreland == 'y') {
                    qualifiedInIrelandTF = true;

                }

                doctorAPI.addDoctor(new General(doctorfullname, doctordob, doctorgender, doctoraddress, contactNumber, quArray, qualifiedInIrelandTF));
            }
        }



    private void listallDoctors() {

        System.out.println(doctorAPI.listDoctors());
    }




    private void listDoctorsByname() {

        System.out.println(doctorAPI.listDoctors());
    }


    private void updatedoctorDetails() {
        //list the doctors
        System.out.println(doctorAPI.listDoctors());

        if (doctorAPI.numberOfDoctors() > 0) {
            //only ask the user to choose a doctor if doctors exist
            int index = ScannerInput.readNextInt("Enter the index of the doctor to update ==> ");

            if ((index >= 0) && (index < doctorAPI.numberOfDoctors())) {
                //if the index is valid, gather new details for each field from the user
                System.out.print("Enter the Doctor Full Name:  ");
                String doctorfullName = sc.nextLine();
                System.out.print("Enter the Doctor dob:  ");
                String doctordob = sc.nextLine();
                System.out.print("Enter the Doctor gender:  ");
                String doctorgender = sc.nextLine();
                System.out.print("Enter the Doctor address:  ");
                String doctoraddress = sc.nextLine();
                System.out.print("Enter the Doctor contactNumber:  ");
                String doctorcontactnumber = sc.nextLine();
            }
        }
    }

    private void updatedoctorQualifications() {
        //list the doctors
        System.out.println(doctorAPI.listDoctors());

    }


    private void updatedoctorSpecialisms() {
        //list the doctors
        System.out.println(doctorAPI.listDoctors());

    }



    private void deleteDoctor() {

        //list the doctors
        System.out.println(doctorAPI.listDoctors());

        if (doctorAPI.numberOfDoctors() > 0) {
            //only ask the user to choose the doctor to delete if doctors exist
            //Ask the user to enter the index of the doctor they wish to delete
            int ind = ScannerInput.readNextInt("Enter the index of the doctor to delete ==> ");

            if ((ind >= 0) && (ind < doctorAPI.numberOfDoctors())) {
                //if the index is valid, delete the doctor at the given index
                doctorAPI.removeDoctor(ind);
                System.out.println("Doctor deleted.");
            } else {
                System.out.println("There is no doctor for this index number");
            }
        }
    }

    private void AnnualFeesreport() {
    }



    private void DoctorreportBycategory() {
    }


    private void Doctorsummaryreport() {
    }



}
