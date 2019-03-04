package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {
	
	@FXML
	private Button signup;
	@FXML
	private TextField username;
	@FXML
	private CheckBox remember;
	@FXML
	private Button login;
	@FXML
	private Button forgotyourpassword;
	@FXML
	private ImageView progress;
	@FXML
	private PasswordField password;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		progress.setVisible(true);
		username.setStyle("-fx-text-inner-color: #a0a2ab");
		password.setStyle("-fx-text-inner-color: #a0a2ab");

		
	}
	@FXML
	public void loginAction(ActionEvent e) {
			progress.setVisible(true);
			PauseTransition pt  =  new PauseTransition();	
			pt.setDuration(Duration.seconds(3));
			pt.setOnFinished(ev ->{
				System.out.println("Login Succsefully");
			});
			pt.play();
	}
	public void signUp(ActionEvent e1) throws IOException {
		login.getScene().getWindow().hide();
		
		Stage signup = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignUP.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
	}
}
