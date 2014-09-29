package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFx application for image and text. Functionalities include load, save,
 * clear
 *
 * @author Paul Ankenman
 * @author Guy Grigsby
 * @author Eric Van Gelder
 * @author Kiem Tech
 * @author Will Zirin
 * @author Aleksandr Gusan
 * @author Kim Bui
 *
 *
 */
public class Main extends Application {

	/** Main stage. */
	private Stage primaryStage;
	/** Window container. */
	private Parent rootLayout;
	@FXML
	private Button img1Load;

	/**
	 * Display the window. Performed at the start of application
	 *
	 * @param stage
	 */
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

	/**
	 * Main method. Activate the start method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
