package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

public class AdministratorController {
        @FXML
        private TextField username;
        @FXML private PasswordField password;
        @FXML private TextArea txtAreaFeedback;






        public void handleHomeBtn(ActionEvent e) throws Exception {
            Main.set_pane(0);
        }

    }

