package controller;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage stage) {
		this.primaryStage=stage;
		this.primaryStage.setTitle("Images Viewer");
		
		try {
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("/view/rootView.fxml"));
			rootLayout=(BorderPane)loader.load();
			Scene scene=new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		showImageViewer();
	}
	
/**
 * show the imageViewer View
 */
	public void showImageViewer(){
		try {
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("/view/ImageViewer.fxml"));
			AnchorPane imgView=(AnchorPane)loader.load();
			rootLayout.setCenter(imgView);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
