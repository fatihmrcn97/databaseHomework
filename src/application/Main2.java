package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root =FXMLLoader.load(getClass().getResource("/Controllers/HomePage.fxml"));
			Scene scene = new Scene(root,757.0,494.0);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
