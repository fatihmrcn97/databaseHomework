package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


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
	private CheckBox remem;
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

	private dbConnection conn;
	private Connection connection;
	private PreparedStatement pst;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		progress.setVisible(true);
		username.setStyle("-fx-text-inner-color: #a0a2ab");
		password.setStyle("-fx-text-inner-color: #a0a2ab");


		
	}
    int count=0;
	@FXML
	public void loginAction(ActionEvent e) {

			progress.setVisible(true);
			PauseTransition pt  =  new PauseTransition();	
			pt.setDuration(Duration.seconds(3));
			pt.setOnFinished(ev ->{

			});
			pt.play();

			connection= conn.getConnection();
			String q1="SELECT * from credentials1 where username=? and password=?";
		try {


			pst=connection.prepareStatement(q1);
			pst.setString(1,username.getText());
			pst.setString(2,password.getText());
			ResultSet rs = pst.executeQuery();

			while(rs.next()){

				count++;


			}if(count==1){

				login.getScene().getWindow().hide();
				Stage home = new Stage();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
					Scene scene = new Scene(root);
					home.setScene(scene);
					home.show();
                    System.out.println(count);
				} catch (IOException e1) {
					e1.printStackTrace();
				}


			}else if(count==2){
                login.getScene().getWindow().hide();
                Stage home = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/AdminPanel.fxml"));
                    Scene scene = new Scene(root);
                    home.setScene(scene);
                    home.show();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }





			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Username or Passaword is not correct");
				alert.show();
				progress.setVisible(true);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	@FXML
	private TableView tableview;
	public void signUp(ActionEvent e1) throws IOException {
		login.getScene().getWindow().hide();
		Stage signup = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignUP.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
	}
	@FXML
	void forgotPas(ActionEvent event) throws SQLException {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText(null);
		alert.setContentText("You can't forgot your password");
		alert.show();
		}
	}


