package Controllers;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.ActionEvent;

public class HomePageController implements Initializable {



    @FXML
    AnchorPane holderPane;
    @FXML
    private Button jobs;

    @FXML
    private Button addjobs;

    @FXML
    private Button history;

    @FXML
    private Button contact;

    @FXML
    private Button ex1;

    @FXML
    private Button logO1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
            createPage();


    }


    private void createPage() {
        try {

            AnchorPane home = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
           holderPane.getChildren().setAll(home);
           FadeTransition fadeIn = new FadeTransition(Duration.millis(100),home);
           fadeIn.setFromValue(0);
           fadeIn.setToValue(1);
           fadeIn.setCycleCount(1);
           fadeIn.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ex(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void logOut(ActionEvent event) {
        try {

            logO1.getScene().getWindow().hide();
            Stage login = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);
            scene.getStylesheets().add("/Controllers/style.css");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
