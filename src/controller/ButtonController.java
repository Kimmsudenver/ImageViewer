package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ButtonController implements javafx.fxml.Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	@FXML
	private Button img1Load,img2Load,img3Load;
	@FXML
	private Button img1Save,img2Save,img3Save;
	@FXML
	private Button img1Clear,img2Clear,Img3Clear;
	@FXML
	private ImageView img1,img2,img3;
	@FXML
	private TextArea textArea;
	
	
	@FXML
	public void loadButton(Event e) {

	}

	@FXML
	public void saveButton(Event e) {

	}

	@FXML
	public void clearButton(Event e) {

	}

}
