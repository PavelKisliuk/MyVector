package by.epam.javatraining.pavelkisliuk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public void start(Stage primaryStage) throws Exception
	{
		String title = "Main Task Window";
		//primaryStage adjustment
		//-----------------------------------------------
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.setTitle(title);
		primaryStage.centerOnScreen();

		//FXML adjustment
		//-----------------------------------------------
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("view\\MyConsole.fxml"));
		Parent fxmlMainWindow = fxmlLoader.load();

		//start-up window
		//-----------------------------------------------
		Scene s = new Scene(fxmlMainWindow);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String... args) {
		launch(args);
	}
}
