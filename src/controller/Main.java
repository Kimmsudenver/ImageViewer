package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private Parent rootLayout;
	@FXML
	private Button img1Load;

	@Override
	public void start(Stage stage) {
		this.primaryStage = stage;
		this.primaryStage.setTitle("Images Viewer");

		try {
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("/view/ImageViewer.fxml"));
			rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
