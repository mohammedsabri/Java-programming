package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;




public class Main extends Application {
    static AnchorPane root;
    static List<AnchorPane> anchor = new ArrayList<AnchorPane>();
    private static int sceneIndex = 0;

    private static User user = null;
// this is what is setting my user type, just for view it is storing the user as null
    // Using the code generator add get and set methods for this static field.


    @Override
    public void start(Stage primaryStage) throws Exception{
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("Anchor.fxml"));
        root.setId("house");

        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("../sample/MainScreen.fxml"))); //index 0
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("LoginAgent.fxml"))); //index 1
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"))); //index 2
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("RegisterAgent.fxml"))); //index 3
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("ViewProperties.fxml"))); //index 4
       anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("Administrator.fxml"))); //index 5
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AgentMain.fxml"))); //index 6
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("RegisterAdministartor.fxml"))); //index 7
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AdminAddProperty.fxml"))); //index 8
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("UpdateProperty.fxml"))); //index 9
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AdminAddAgent.fxml"))); //index 10
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AgentUpdateProperty.fxml"))); //index 11
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AgentAddProperty.fxml"))); //index 12




        Scene scene = new Scene(root, 700, 400);
        scene.getStylesheets().addAll(this.getClass().getResource("MyStyle.css").toExternalForm());

        root.getChildren().add(anchor.get(0));
        primaryStage.setTitle("Mo's Properties");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void init_app(){
        for(int i=0; i<anchor.size();i++){
            //can be used to initiate some details about each pane
        }
    }

    public static AnchorPane get_pane(int index){
        return anchor.get(index);
    }

    public static void set_pane(int index){
        //TODO check that the index is valid ie. >0 and <size of ArrayList
        root.getChildren().remove(anchor.get(sceneIndex));  //remove the existing pane from the root
        root.getChildren().add(anchor.get(index));          //add the selected pane to the root
        sceneIndex=index;                                   //update the stored sceneIndex
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setUser(User user) {
        Main.user = user;
    }
}
