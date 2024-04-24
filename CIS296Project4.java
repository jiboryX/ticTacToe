package cis296project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CIS296Project4 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HelloFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show(); 
    }
    
}
