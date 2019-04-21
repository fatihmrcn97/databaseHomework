package Controllers;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.xml.soap.Text;
import java.net.URL;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane home;

    @FXML
    private Button personal;

    @FXML
    private Button job;

    @FXML
    private Label name2234;


    @Override
    public void initialize(URL location, ResourceBundle resources){


    }
    @FXML
    void personalAction(ActionEvent event) throws SQLException,IOException {

            Connection conn = dbConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM freelancer");
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getString(1) +  rs.getString(2) + rs.getString(3));

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
    @FXML
    private Button abc;

    @FXML
    void aaaa(ActionEvent event) {
        name2234.setText("gegeaga");
    }


}
