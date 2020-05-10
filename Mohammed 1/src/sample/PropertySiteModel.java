package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.scene.control.ListView;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class PropertySiteModel {

    public ArrayList<Property> house;

    public ArrayList<Property> getHouse() {
        return house;
    }

    public void setHouse(ArrayList<Property> house) {
        this.house = house;
    }

    public PropertySiteModel() {
        house = new ArrayList<Property>();
    }

    public void addProperty(int id, String desc, String address, String category, String town, String ber, String eircode, int price, String agentName, int phoneNumber, String PriceMin, String PriceMix) {
        Property property = new Property(id, desc, address, category, town, ber, eircode, price, agentName, phoneNumber,PriceMin,PriceMix);
        house.add(property);
    }


    // This method returns the index number and the title of each

    //  element in the Property ArrayList.


    public String listProperties() {
        int i = 0;
        String displayProperties = "All Properties";
        for (Property item : house) {
            displayProperties += "\n" + (i++) + ": " + item;
        }
        return displayProperties;
    }

    public int getSize() {
        return house.size();
    }







    // get Property details


    public Property getPropDetails(String id) {


        try {
            int id1 = (Integer.parseInt(id));  //Test only


            for (Property item : house) {

                if (item.getId() == id1) {

                    return item;

                }

            }
        } catch (Exception e) {

        }
        return null;


    }


    //This method saves it to an XML file called properties.xml


    public void saveProperties() throws Exception {
        XStream xStream = new XStream(new DomDriver());
        ObjectOutputStream out = xStream.createObjectOutputStream
                (new FileWriter("properties.xml"));
        out.writeObject(house);
        out.close();
    }


    //This method loads the properties it to an XML file called properties.xml


    public void loadProperties() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("properties.xml"));
        house = (ArrayList<Property>) is.readObject();
        is.close();

    }




    public void UpdateProperty(String id) {

        Property prop = null;

        int id1 = (Integer.parseInt(id));

        int i = 0;
        do {
            if (house.get(i).getId() == id1) {
                house.remove(i);

            }
            i++;
        }
        while (i < house.size());
    }

    public void deleteProperty(int id) {

        house.remove(id);


    }

    public void addToListBox(ListView lstView) {
        lstView.getItems().clear();
        for (int i = 0; i < house.size(); i++) {
            lstView.getItems().add(house.get(i));

        }
        //txtFeedBack.setText("Properties!!!");
    }

    public void addToCatListBox(ListView lstView, String category) {
        lstView.getItems().clear();
        for (int i = 0; i < house.size(); i++) {
            if (category.equalsIgnoreCase("all"))
                lstView.getItems().add(house.get(i));
            else if (house.get(i).getCategory().equalsIgnoreCase(category))
                lstView.getItems().add(house.get(i));

        }

    }


    public void addToTownListBox(ListView lstView, String town) {
        lstView.getItems().clear();
        for (int i = 0; i < house.size(); i++) {
            if (town.equalsIgnoreCase("all"))
                lstView.getItems().add(house.get(i));
            else if (house.get(i).getTown().equalsIgnoreCase(town))
                lstView.getItems().add(house.get(i));


        }
    }


    public void addToPriceMinListBox(ListView lstView, String PriceMin) {
        lstView.getItems().clear();
        for (int i = 0; i < house.size(); i++) {
            if (PriceMin.equalsIgnoreCase("all"))
                lstView.getItems().add(house.get(i));
            else if (house.get(i).getPriceMin().equalsIgnoreCase(PriceMin))
                lstView.getItems().add(house.get(i));

        }
    }


    public void addToPriceMixListBox(ListView lstView, String PriceMiX) {
        lstView.getItems().clear();
        for (int i = 0; i < house.size(); i++) {
            if (PriceMiX.equalsIgnoreCase("all"))
                lstView.getItems().add(house.get(i));
            else if (house.get(i).getPriceMix().equalsIgnoreCase(PriceMiX))
                lstView.getItems().add(house.get(i));


        }
    }



        }






