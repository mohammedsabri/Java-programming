import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DoctorAPI {
    private ArrayList<Doctor> doctors;


    {
        doctors = new ArrayList<Doctor>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }


    public Doctor getDoctor(int ind) {
        //doctors.get(doctors);
        if (ind < 0 || doctors.size() <= ind) {
            return null;
        } else {
            return doctors.get(ind);
        }
    }


    public boolean removeDoctor(int ind) {
        if (ind < 0 || doctors.size() <= ind) {
            return false;
        }
        else {
            doctors.remove(ind);
            return true;
        }
    }


        public int numberOfDoctors () {
            return doctors.size();
        }



        public String listDoctors () {
            if (doctors.size() == 0) {
                return "No Doctors.";
            } else {
                String listDoctors = "";
                for (int i = 0; i < doctors.size(); i++) {
                    listDoctors = listDoctors + i + ": " + doctors.get(i) + "\n";
                }
                return listDoctors;
            }

        }

        public String listDoctors (String docType){
            if (doctors.size() == 0) {
                return "No Doctors.";
            } else {
                String listDoctors = "";
                for (int i = 0; i < doctors.size(); i++) {

                    if(doctors.get(i) instanceof Intern && docType.equalsIgnoreCase("intern"))
                        listDoctors = listDoctors + i + ": " + doctors.get(i) + "\n";

                    if(doctors.get(i) instanceof Specialist && docType.equalsIgnoreCase("specialist"))
                        listDoctors = listDoctors + i + ": " + doctors.get(i) + "\n";

                    if(doctors.get(i) instanceof General && docType.equalsIgnoreCase("general"))
                        listDoctors = listDoctors + i + ": " + doctors.get(i) + "\n";
                }
                return listDoctors;
            }
        }


        public ArrayList<Doctor> searchDoctorsByName (String docName) {

            ArrayList<Doctor> newArr = new ArrayList<>();
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getName().equalsIgnoreCase(docName)) {
                    newArr.add( doctors.get(i));
                }
            }
            return newArr;
        }

            public int calculateAnnualFees () {
              return 0;
            }

//            public Doctorreport();{
//
//    }
//
//            public Doctorsummaryreport();{
//
//    }


        @SuppressWarnings("unchecked")
        public void load () throws Exception
        {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("doctors.xml"));
            doctors = (ArrayList<Doctor>) is.readObject();
            is.close();
        }

        public void save () throws Exception
        {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("doctors.xml"));
            out.writeObject(doctors);
            out.close();
        }

    }




