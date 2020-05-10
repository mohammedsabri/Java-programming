package sample;
import java.util.ArrayList;

import sample.Main;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.User;

import java.io.*;

public class RegisterController {

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private PasswordField repeat_password;

    @FXML private Label txtAreaFeedback;

    public void handleRegisterBtn(ActionEvent e) throws Exception {
        if(username.getText().length()<4 || password.getText().length()<4 ) {
            txtAreaFeedback.setText("Username and Password need to be 4 characters or more");
        } else if(!password.getText().equals(repeat_password.getText())){
            txtAreaFeedback.setText("Password must match RepeatPassword");
        }
        else if(register(username.getText(),password.getText()
                )){
            txtAreaFeedback.setText("Successful Registration"); //Never be seen because of next line
            Main.set_pane(0);
        }
    }

    private boolean register(String username, String password) {
        ArrayList<User> users;
        XStream xstream = new XStream(new DomDriver());
        try {
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("registerAgent.xml"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        }
        catch(FileNotFoundException e) {
            users =  new ArrayList<User>();
            txtAreaFeedback.setText("New Password File");
        }
        catch (Exception e) {
            txtAreaFeedback.setText("Error accessing Password File");
            return false;
        }

        //TODO should check username does not already exists
        try {
            User user = new User(username,password);
            users.add(user);
            Main.setUser(user);
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("registerAgent.xml"));
            out.writeObject(users);
            out.close();
        }
        catch (Exception e) {
            txtAreaFeedback.setText("Error writing to Password File");
            return false;
        }
        return true;
    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }
}
