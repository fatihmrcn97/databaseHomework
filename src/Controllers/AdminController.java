package Controllers;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;


public class AdminController implements Initializable {

    @FXML
    AnchorPane holderPane;


    @FXML
    private Button addjobs1;


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

        if(file123==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Image can not be null");
            alert.show();
        }else  {
            if(phoneNumber.getText().length()==11) {
                try {
                    String Insert = "INSERT INTO PersonForm1(PersonName,PersonSurname,PersonSkill,PersonPhoneNumber,PersonUniversity,picture)"
                            + "VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(Insert);
                    pst.setString(1, name.getText());
                    pst.setString(2, surname.getText());
                    pst.setString(3, skillPerson.getText());
                    pst.setString(4, phoneNumberPerson.getText());
                    pst.setString(5, university.getText());
                    fis = new FileInputStream(file123);
                    pst.setBinaryStream(6, (InputStream) fis, (int) file123.length());

                    pst.execute();
                    connection.close();
                } catch (SQLException | FileNotFoundException e2) {
                    e2.printStackTrace();
                    System.out.println("Gon an exception");
                    System.out.println(e2.getMessage());
                }
                name.setText("");
                surname.setText("");
                skillPerson.setText("");
                phoneNumberPerson.setText("");
                university.setText("");

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Phone number must be 11 digit");
                alert.show();
            }
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
        if(price!=null || price.getText()!="0"){
            if(phoneNumber.getText().length()==11){
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
                jobTitle.setText("");
                description.setText("");
                jobFormSkill.setText("");
                price.setText("");
                phoneNumber.setText("");
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Phone Number must be 11 digit");
                alert.show();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Price must be entered");
            alert.show();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Controllers/style3.css");


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
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("oguzhansafran1@gmail.com","emma1903");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("oguzhansafran1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("fatihmercan1997@hotmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Hello this is not spam," +
                    "\n\n This is a JavaMail test...!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private TableView<ModelTable> tableview;
    @FXML
    private TableColumn<ModelTable,String > title;

    @FXML
    private TableColumn<ModelTable,String> desc;

    @FXML
    private TableColumn<ModelTable,String> skl;

    @FXML
    private TableColumn<ModelTable,String> pric;

    @FXML
    private TableColumn<ModelTable,String> pNum;
    @FXML
    private Button hide;
    ObservableList<ModelTable> oblist= FXCollections.observableArrayList();
    @FXML
    void showAction(ActionEvent event) throws SQLException {


        connection=dbConnection.getConnection();
        ResultSet rs=connection.createStatement().executeQuery("select * from jobForm1");
        while (rs.next()){
            oblist.add(new ModelTable(rs.getString("jobTitle"),
                    rs.getString("descriptionForm"),
                    rs.getString("Skills"),
                    rs.getString("Price"),
                    rs.getString("phoneNumber")));
        }
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        skl.setCellValueFactory(new PropertyValueFactory<>("skills"));
        pric.setCellValueFactory(new PropertyValueFactory<>("price"));
        pNum.setCellValueFactory(new PropertyValueFactory<>("phoeNum"));

        tableview.setItems(oblist);

        hide.setVisible(false);
    }
    @FXML
    private TableView<ModelTable1> tableP;

    @FXML
    private TableColumn<ModelTable1,String> nameP;

    @FXML
    private TableColumn<ModelTable1,String> surnameP;

    @FXML
    private TableColumn<ModelTable1,String> skillP;

    @FXML
    private TableColumn<ModelTable1,String> phoneP;

    @FXML
    private TableColumn<ModelTable1,String> univerP;

    @FXML
    private Button hideP;
    ObservableList<ModelTable1> oblist1= FXCollections.observableArrayList();
    @FXML
    void shopP(ActionEvent event) throws SQLException {
        connection=dbConnection.getConnection();
        ResultSet rs=connection.createStatement().executeQuery("select * from PersonForm1");

        while (rs.next()){
            oblist1.add(new ModelTable1(rs.getString("PersonName"),rs.getString("PersonSurname"),
                    rs.getString("PersonSkill"),rs.getString("PersonPhoneNumber"),rs.getString("PersonUniversity")));
            System.out.println(rs.getString("PersonName")+rs.getString("PersonSurname")+
                    rs.getString("PersonSkill")+rs.getString("PersonPhoneNumber")+rs.getString("PersonUniversity"));
        }
        nameP.setCellValueFactory(new PropertyValueFactory<>("PersonName1"));
        surnameP.setCellValueFactory(new PropertyValueFactory<>("PersonSurname1"));
        skillP.setCellValueFactory(new PropertyValueFactory<>("PersonSkill1"));
        phoneP.setCellValueFactory(new PropertyValueFactory<>("PersonPhoneNumber1"));
        univerP.setCellValueFactory(new PropertyValueFactory<>("PersonUniversity1"));

        tableP.setItems(oblist1);
        tableP.setEditable(true);
        hideP.setVisible(false);


    }

    @FXML
    private TextField screen;

    @FXML
    void displaySelected(MouseEvent event) throws SQLException, IOException {
        ModelTable1 person = tableP.getSelectionModel().getSelectedItem();
        if(person==null){
            screen.setText("Nothing Selected");
        }else{
            String name = person.getPersonName1();
            String surname = person.getPersonSurname1();

            screen.setText(name+" "+surname);
            pst=connection.prepareStatement("select * from PersonForm1 where PersonName ='"+name+"'");
            ResultSet rs;
            rs=pst.executeQuery();
            while(rs.next())
            {
                InputStream is = rs.getBinaryStream("picture");
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[]content = new byte[1024];
                int size = 0;
                while((size=is.read(content))!= -1)
                {
                    os.write(content,0,size);
                }
                os.close();
                is.close();
                Image imagex = new Image("file:photo.jpg",114,137,true,true);
                imagePerson1.setImage(imagex);


            }
        }
    }
    @FXML
    private ImageView imagePerson1;

    @FXML
    private ImageView imagePerson;
    FileChooser fileChooser1;
    File file123;
    BufferedImage bufferedImage;
    Image image;
    @FXML
    void browserActionPerson(ActionEvent event) throws IOException {

        fileChooser1=new FileChooser();
        fileChooser1.setInitialDirectory(new File("C:\\Users\\fatihmercan\\Desktop\\ProjectLastVersion\\databaseHomework"));
        file123=fileChooser1.showOpenDialog(null);
        if( file123 != null){
            bufferedImage = ImageIO.read(file123);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            imagePerson.setImage(image);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Image does not find");
            alert.show();
        }

    }
    private FileInputStream fis;


    @FXML
    void hired(ActionEvent event) {
        ModelTable1 person = tableP.getSelectionModel().getSelectedItem();
        if(person==null){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Nothing Selected");
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("We will send an e-mail");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText(null);
                alert1.setContentText("We send an e-mail to you , waite for response.");
                alert1.show();
            } else {
                // ... user chose CANCEL or closed the dialog
                Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                alert3.setHeaderText(null);
                alert3.setContentText("Look for better personal.");
                alert3.show();
            }
        }
    }
    @FXML
    private TextField calculate;

    @FXML
    void calculateAction(ActionEvent event) throws SQLException {

        ModelTable person = tableview.getSelectionModel().getSelectedItem();
        String name = person.getTitle();
        pst=connection.prepareStatement("select * from jobForm1 where jobTitle ='"+name+"'");
        ResultSet rs;
        int a,b,c;
        a =Integer.valueOf(calculate.getText());
        rs=pst.executeQuery();
        while (rs.next()){
            c = rs.getInt("Price");
            b=a * c;

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("You will earn : "+b+" ₺");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setHeaderText(null);
                alert1.setContentText("We send an e-mail to you , waite for response.");
                alert1.show();
            } else {
                // ... user chose CANCEL or closed the dialog
                Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                alert3.setHeaderText(null);
                alert3.setContentText("Look for better jobs.");
                alert3.show();
            }



        }
    }
}
