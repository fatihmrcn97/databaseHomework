package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupController implements Initializable {

	@FXML
	private Button signup;
	@FXML
	private TextField username1;
	@FXML
	private TextField adress;
	@FXML
	private TextField introduce;
	@FXML
	private CheckBox male;
	@FXML
	private CheckBox female;
	@FXML
	private Button login;
	@FXML
	private Button forgotyourpassword;
	@FXML
	private ImageView progress;
	@FXML
	private PasswordField password1;
	private PreparedStatement pst;
	private Connection connection;
	private dbConnection con;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		username1.setStyle("-fx-text-inner-color: #a0a2ab");
		password1.setStyle("-fx-text-inner-color: #a0a2ab");
		adress.setStyle("-fx-text-inner-color: #a0a2ab");
		introduce.setStyle("-fx-text-inner-color: #a0a2ab");
	}
	@FXML
	public void signUP(ActionEvent ae1) {

con =new dbConnection();


		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(e ->{
			System.out.println("sign up successfuly");
		});
		pt.play();
		String Insert = "INSERT INTO loginData(username,userpassword,gender,city)"
				+"VALUES (?,?,?,?,?)";

		connection=con.getConnection();
		try {
			pst = connection.prepareStatement(Insert);
		}catch (SQLException e){
			e.printStackTrace();
		}try {


		pst.setString(1, username1.getText());
		pst.setString(2,password1.getText());
		pst.setString(3,getGender());
		pst.setString(4,adress.getText());
		pst.setString(5,introduce.getText());
		pst.executeUpdate();
		}catch (SQLException e2){
			e2.printStackTrace();
		}

	}
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
	public String getGender(){
		String gen="";
		if(male.isSelected()){
			gen = "Male";
		}else if(female.isSelected())
			gen="Female";
	return gen;
	}


}
