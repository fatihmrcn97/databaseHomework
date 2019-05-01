package Controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;

public class SignupController implements Initializable {

	@FXML
	private Button signup;
	@FXML
	private TextField username1;
	@FXML
	private TextField adress;
	@FXML
	private TextField location;
	@FXML
	private TextField introduce	;
	@FXML
	private RadioButton amale;
	@FXML
	private RadioButton afemale;
	@FXML
	private Button login;
	@FXML
	private Button browser;

	private File file;
	private FileChooser fileChooser;

	@FXML
	private Button forgotyourpassword;
	@FXML
	private ImageView pictUser;
	@FXML
	private PasswordField password1;
	private PreparedStatement pst;
	private Connection connection;
	private dbConnection con;
	Stage stage=new Stage();

	public String getGender(){

		String gen="";
		if(amale.isSelected()){
			gen = "Male";
		}else if(afemale.isSelected())
			gen="Female";
		return gen;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		

		username1.setStyle("-fx-text-inner-color: #a0a2ab");
		password1.setStyle("-fx-text-inner-color: #a0a2ab");
		adress.setStyle("-fx-text-inner-color: #a0a2ab");

		con =new dbConnection();

	}
	@FXML
	public void signUP(ActionEvent ae1) {

 

		connection=con.getConnection();
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(e ->{

		});
		pt.play();


		try {
			String Insert = "INSERT INTO credentials1(username,password,gender,email,location1)"
					+"VALUES (?,?,?,?,?)";
		pst=connection.prepareStatement(Insert);
		pst.setString(1, username1.getText());
		pst.setString(2,password1.getText());
		pst.setString(3,getGender());
			pst.setString(4,adress.getText());
		pst.setString(5,location.getText());

		username1.setText("");
		password1.setText("");
		adress.setText("");
		afemale.setSelected(false);
		amale.setSelected(false);
		pst.execute();
		location.setText("");
		connection.close();
		}catch (SQLException e2){
			e2.printStackTrace();
			System.out.println("Gon an exception");
			System.out.println(e2.getMessage());
		}

	}
	private FileInputStream fis;
	@FXML
	public void loginAction(ActionEvent ae2) throws IOException {
		signup.getScene().getWindow().hide();
		Stage login = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
			Scene scene = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
		scene.getStylesheets().add("/Controllers/style.css");

	}
	@FXML
	private TextArea textArea;
	File file123;
	BufferedImage bufferedImage;
	Image image;
	@FXML
	void browseronAction(ActionEvent event) throws IOException {
FileChooser fileChooser1=new FileChooser();
	File file123=fileChooser1.showOpenDialog(null);
	if( file123 != null){
		BufferedImage bufferedImage = ImageIO.read(file123);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		pictUser.setImage(image);
	}else {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Image does not find");
		alert.show();
	}
	}



}
