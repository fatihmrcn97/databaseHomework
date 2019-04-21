package Controllers;

import application.EmailUtil;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.ActionEvent;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    @FXML
    private TextField jobFormSkill;

    @FXML
    private TextField jobTitle;

    @FXML
    private TextField description;
    @FXML
    private TextField subjectText;

    @FXML
    private TextField mailText;

    @FXML
    private TextField price;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField skillPerson;

    @FXML
    private TextField phoneNumberPerson;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;
    @FXML
    private TextField university;


    @FXML
    void addPersonAction(ActionEvent event) {
        connection=con.getConnection();
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e ->{

        });
        pt.play();


        try {
            String Insert = "INSERT INTO PersonForm1(PersonName,PersonSurname,PersonSkill,PersonPhoneNumber,PersonUniversity)"
                    +"VALUES (?,?,?,?,?)";
            pst=connection.prepareStatement(Insert);
            pst.setString(1, name.getText());
            pst.setString(2,surname.getText());
            pst.setString(3,skillPerson.getText());
            pst.setString(4,phoneNumberPerson.getText());
            pst.setString(5,university.getText());

            pst.execute();
            connection.close();
        }catch (SQLException e2){
            e2.printStackTrace();
            System.out.println("Gon an exception");
            System.out.println(e2.getMessage());
        }
    }
    Connection connection;
    dbConnection con;
    PreparedStatement pst;
    @FXML
    void AddJobFormAction(ActionEvent event) {
        connection=con.getConnection();
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e ->{

        });
        pt.play();


        try {
            String Insert = "INSERT INTO jobForm1(jobTitle,descriptionForm,Skills,Price,phoneNumber)"
                    +"VALUES (?,?,?,?,?)";
            pst=connection.prepareStatement(Insert);
            pst.setString(1, jobTitle.getText());
            pst.setString(2,description.getText());
            pst.setString(3,jobFormSkill.getText());
            pst.setString(4,price.getText());
            pst.setString(5,phoneNumber.getText());

            pst.execute();
            connection.close();
        }catch (SQLException e2){
            e2.printStackTrace();
            System.out.println("Gon an exception");
            System.out.println(e2.getMessage());
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    



    }
    @FXML
    void jobAction(ActionEvent event) {
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
    @FXML
    void AddPersonAction(ActionEvent event){
        try {

            AnchorPane home1 = FXMLLoader.load(getClass().getResource("/FXML/PersonFrom.fxml"));

            holderPane.getChildren().setAll(home1);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void addjobsAction(ActionEvent event) throws IOException {
        AnchorPane home1 = FXMLLoader.load(getClass().getResource("/FXML/JobForm.fxml"));

        holderPane.getChildren().setAll(home1);

    }
    @FXML
    void contactAction(ActionEvent event) throws IOException {
        AnchorPane home1 = FXMLLoader.load(getClass().getResource("/FXML/contact.fxml"));

        holderPane.getChildren().setAll(home1);

    }
    @FXML
    void sendAction(ActionEvent event) {
        connection=con.getConnection();
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e ->{

        });
        pt.play();

     sendMail();
    }
    @FXML
    private TextField mail;


    public void sendMail(){
        // Recipient's email ID needs to be mentioned.
        String to = "fatihmercan1997@hotmail.com";

        // Sender's email ID needs to be mentioned
        String from = mail.getText();

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subjectText.getText());

            // Now set the actual message
            message.setText(mailText.getText());

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    }





