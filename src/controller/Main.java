package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Main INSTANCE;

	private Stage primaryStage;
	private Parent rootLayout;
	@FXML

	@Override
	public void start(Stage stage) {
		INSTANCE = this;
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
	
	public Stage getStage() {
		return primaryStage;
	}
	
	public static Main getInstance() {
		return INSTANCE;
	}
}
