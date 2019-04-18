package Controllers;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane home;

    @FXML
    private Button personal;

    @FXML
    private Button job;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    @FXML
    void personalAction(ActionEvent event) {

        try {

            AnchorPane home1 = FXMLLoader.load(getClass().getResource("/FXML/personelPage.fxml"));
            home.getChildren().setAll(home1);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1000),home1);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }  @FXML
    void jobAction(ActionEvent event) {
        try {

            AnchorPane home1 = FXMLLoader.load(getClass().getResource("/FXML/Jobs.fxml"));
            home.getChildren().setAll(home1);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1000),home1);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
