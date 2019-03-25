package Controllers;

import java.io.IOException;
import java.net.URL;
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
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(e ->{
			System.out.println("sign up successfuly");
		});
		pt.play();
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
}
