package sample;
/**
 * @Name: Mohammed Sabri
 * @Version 1.0
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class MainController implements Initializable {

   protected static PropertySiteModel houseObj;
    protected static AgentModel agent;
    String town, category, PriceMin, PriceMix;
    static Property choosenProperty;

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtdescription;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtcategory;
    @FXML
    private TextField txttown;
    @FXML
    private TextField txtber;
    @FXML
    private TextField txteircode;
    @FXML
    private TextField txtprice;
    @FXML
    private TextField txtagentName;
    @FXML
    private TextField txtphoneNumber;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtFeedBack;


    @FXML
    private TextArea txtAreaPropertyInfo = new TextArea();

    @FXML
    private ListView lstView;// = new ListView();
    @FXML
    private ComboBox<String> comboCategory = new ComboBox<>();
    @FXML
    private ComboBox<String> comboTown = new ComboBox<>();
    @FXML
    private ComboBox<String> comboPriceMix = new ComboBox<>();
    @FXML
    private ComboBox<String> comboPriceMin = new ComboBox<>();

    ObservableList<String> Categories = FXCollections.observableArrayList("All", "Detached", "Semi-Detached", "Terraced", "Apartment");
    ObservableList<String> towns = FXCollections.observableArrayList("All", "Dublin", "Waterford", "Limerick", "Cork");
    ObservableList<String> priceMix = FXCollections.observableArrayList("All", "25,000", "75,000", "100,000", "200,000", "950,000", "1,750,000", "4,500,000");
    ObservableList<String> priceMin = FXCollections.observableArrayList("All", "25,000", "75,000", "100,000", "200,000", "950,000", "1,750,000", "4,500,000");




    public void initialize(URL location, ResourceBundle resources) {

        houseObj = new PropertySiteModel();
        agent = new AgentModel();


        category ="All";
        town = "All";



        comboCategory.setItems(Categories);
        comboTown.setItems(towns);
        comboPriceMix.setItems(priceMix);
        comboPriceMin.setItems(priceMin);





        comboCategory.setValue("Category");
        comboTown.setValue("Town");
        comboPriceMix.setValue("Mix");
        comboPriceMin.setValue("Min");
        try{
            houseObj.loadProperties();
            agent.loadAgents();}
        catch (Exception e){
            System.out.println(e.toString());}


    }




// these bring up the screens
        public void handleLoginAgentBtn(ActionEvent e) throws Exception {
        Main.set_pane(1);

    }

    public void handleLoginAdminBtn(ActionEvent e) throws Exception {
        Main.set_pane(2);


    }

    public void handleRegisterBtn(ActionEvent e) throws Exception {
        Main.set_pane(3);

    }

    public void handleViewPropertiesBtn(ActionEvent e) throws Exception {
        Main.set_pane(4);
    }




    public void handleRegisterAdmin(ActionEvent e) throws Exception {
        Main.set_pane(7);
    }



    public void handleBackAgentBtn (ActionEvent e) throws Exception {
        Main.set_pane(6);
    }


    public void handleBackAdminBtn (ActionEvent e) throws Exception {
        Main.set_pane(5);
    }

    public void handleHomeBtn (ActionEvent e) throws Exception {
        Main.set_pane(0);
    }










// show the Properties on the selected item
    public void handleCategoryBtn (ActionEvent e) throws Exception {
        category = comboCategory.getValue();
        houseObj.addToCatListBox(lstView, category);

    }

    public void handletownBtn (ActionEvent e) throws Exception {
        town = comboTown.getValue();
        houseObj.addToTownListBox(lstView, town);
    }


    public void handlePriceMinBtn (ActionEvent e) throws Exception {
        PriceMin = comboPriceMin.getValue();
        houseObj.addToPriceMinListBox(lstView, PriceMin);

    }

    public void handlePriceMixBtn (ActionEvent e) throws Exception {

        PriceMix = comboPriceMix.getValue();
        houseObj.addToPriceMixListBox(lstView, PriceMix);


    }









// this just list all the agent
    public void handleListAgentBtn (ActionEvent e) throws Exception {
        agent.addToListBox(lstView);
    }




    // this load all the Properties
public void loadUpdateProperty(){
    txtid.setText(choosenProperty.getId()+"");

    txtdescription.setText(choosenProperty.getDescription()+"");


    txtaddress.setText(choosenProperty.getAddress());

    txtcategory.setText(choosenProperty.getCategory());

    txttown.setText(choosenProperty.getTown());

    txtber.setText(choosenProperty.getBer());

    txteircode.setText(choosenProperty.getEircode());

    txtprice.setText("" + choosenProperty.getPrice());

    txtagentName.setText(choosenProperty.getAgentName());

  txtphoneNumber.setText(" " + choosenProperty.getPhoneNumber());

}
  // this load all the Properties as agent
    public void loadAgentUpdateProperty(){
        txtid.setText(choosenProperty.getId()+"");

        txtdescription.setText(choosenProperty.getDescription()+"");


        txtaddress.setText(choosenProperty.getAddress());

        txtcategory.setText(choosenProperty.getCategory());

        txttown.setText(choosenProperty.getTown());

        txtber.setText(choosenProperty.getBer());

        txteircode.setText(choosenProperty.getEircode());

        txtprice.setText("" + choosenProperty.getPrice());

        txtagentName.setText(choosenProperty.getAgentName());

        txtphoneNumber.setText(" " + choosenProperty.getPhoneNumber());

    }

// this bring up the  update the Property As an Admin screen
public void handleUpdateScreenBtn(ActionEvent e) throws Exception {
    choosenProperty = (Property)lstView.getSelectionModel().getSelectedItem();

    Main.set_pane(9);

}



    // this bring up the  update the Property As an Agent screen
    public void handleAgentUpdateScreenBtn(ActionEvent e) throws Exception {
        choosenProperty = (Property)lstView.getSelectionModel().getSelectedItem();

        Main.set_pane(11);

    }


// this update the Property
    public void handleUpdateBtn(ActionEvent e) throws Exception {

          int id = Integer.parseInt(txtid.getText());
        choosenProperty.setId(id);


          String description = txtdescription.getText();

          String address = txtaddress.getText();

          String eircode = txteircode.getText();

          String ber = txtber.getText();

          String cat = comboCategory.getValue();

          String town = comboTown.getValue();

          double price = Double.parseDouble(txtprice.getText());

      //  txtFeedBack.setText("Property Updated");

        txtdescription.clear();
        txtber.clear();
        txteircode.clear();


        }

// this Update the Property as agent
    public void handleAgentUpdatePropertyBtn(ActionEvent e) throws Exception {

        int id = Integer.parseInt(txtid.getText());
        choosenProperty.setId(id);



        String description = txtdescription.getText();

        String address = txtaddress.getText();

        String eircode = txteircode.getText();

        String ber = txtber.getText();

        String cat = comboCategory.getValue();

        String town = comboTown.getValue();

        double Price = Double.parseDouble(txtprice.getText());



      //  txtFeedBack.setText("Property Updated");

        txtdescription.clear();
        txtber.clear();
        txteircode.clear();


    }


  // this uses the lstview to search
    public void handlesearchBtn(ActionEvent e) throws Exception {

        houseObj.addToListBox(lstView);
      //  houseObj.loadProperties();

    }







// this list all the Properties on the lstview
    public void handlelistBtn(ActionEvent e) throws Exception {
       //String list = house.listProperties();
       // txtAreaPropertyInfo.setText(list);
        houseObj.addToListBox(lstView);
    }


    //this delete a agent at the selected line on the lstview
    public void handleDeleteAgentBtn (ActionEvent e) throws Exception {
        int id = lstView.getSelectionModel().getSelectedIndex();
        agent.DeleteAgents(id);
        txtFeedBack.setText("Agent Deleted");
        agent.addToListBox(lstView);



    }

        //this delete a property at the selected line on the lstview
        public void handleDeleteBtn (ActionEvent e) throws Exception {

        int id = lstView.getSelectionModel().getSelectedIndex();
            houseObj.deleteProperty(id);
        txtFeedBack.setText("Property Deleted");
            houseObj.saveProperties();
            houseObj.addToListBox(lstView);

        }






// this add a new Property as an agent
    public void handleAgentAddPropertyBtn (ActionEvent e) throws Exception {
        // this bring up the screen
        Main.set_pane(12);
        int id = Integer.parseInt(txtid.getText());
        String desc = txtdescription.getText();
        String address = txtaddress.getText();
        String category = txtcategory.getText();
        String town = txttown.getText();
        String ber = txtber.getText();
        String eircode = txteircode.getText();
        int price = Integer.parseInt(txtprice.getText());
        String agentName = txtagentName.getText();
        int phoneNumber = Integer.parseInt(txtphoneNumber.getText());

        houseObj.addProperty(id,desc,address,category,town, ber, eircode, price, agentName, phoneNumber,PriceMin,PriceMix);
        houseObj.saveProperties();
        txtFeedBack.setText("Property Added");

    }

// this add a new Property
        public void handleAddPropAdminBtn (ActionEvent e) throws Exception {

        // this bring up the screen
        Main.set_pane(8);
            int id = Integer.parseInt(txtid.getText());
            String desc = txtdescription.getText();
            String address = txtaddress.getText();
            String category = txtcategory.getText();
            String town = txttown.getText();
            String ber = txtber.getText();
            String eircode = txteircode.getText();
            int price = Integer.parseInt(txtprice.getText());
            String agentName = txtagentName.getText();
            int phoneNumber = Integer.parseInt(txtphoneNumber.getText());

        houseObj.addProperty(id,desc,address,category,town, ber, eircode, price, agentName, phoneNumber,PriceMin,PriceMix);
        houseObj.saveProperties();




              txtFeedBack.setText("Property Added");
    }





// this bring up the screen for the add agent
    public void handleAddAgentScreenBtn (ActionEvent e) throws Exception {


        Main.set_pane(10);
    }
// this add a new agent to the list
    public void handleAddAgentBtn (ActionEvent e) throws Exception {
        int id = Integer.parseInt(txtid.getText());
        String username = txtusername.getText();
        String password = txtpassword.getText();
        agent.addAgent(id,username,password);
        agent.saveAgents();


    }

    }




