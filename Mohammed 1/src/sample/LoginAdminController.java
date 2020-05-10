package sample;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;
import sample.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoginAdminController {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private TextArea txtAreaFeedback;


    public void handleLoginBtn(ActionEvent e) throws Exception {
        if(username.getText().length()<4 || password.getText().length()<4 ){
            txtAreaFeedback.setText("Username and Password need to be 4 characters or more");
        }
        else if(login(username.getText(),password.getText())){
            txtAreaFeedback.setText("Successful Login");
            //
            Main.set_pane(5);   //If you use this line of code, successful login will automatically return to the home scene
        }
        else {
            txtAreaFeedback.setText("Un-Successful Login");
            password.clear();
        }
    }

    private boolean login(String username, String password) {
        ArrayList<User> users = null;
        XStream xstream = new XStream(new DomDriver());
        try {
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("registerAdmin.xml"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        }
        catch(FileNotFoundException e) {
            users =  new ArrayList<User>();
            txtAreaFeedback.setText("Password File not located");
            return false;

        }
        catch (Exception e) {
            txtAreaFeedback.setText("Error accessing Password File");
            return false;
        }

        for (User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Main.setUser(user);//sets the user from null to what ever the user is, if administrator or property agent it goes on user type that is on User class
                return true;
            }
        }
        return false;
    }

    public void handleHomeBtn(ActionEvent e) throws Exception {
        Main.set_pane(0);
    }

}
