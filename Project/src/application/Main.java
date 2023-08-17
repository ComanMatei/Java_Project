package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * Starts application
 */

public class Main extends Application {

	private static Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("/resouces/view/LogIn.fxml"));
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Image icon = new Image("barberIcon.png");
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("HeadLock Studios");
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
