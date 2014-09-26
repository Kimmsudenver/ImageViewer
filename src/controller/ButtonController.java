package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class ButtonController implements javafx.fxml.Initializable {
	@FXML
	private Button img1Load, img2Load, img3Load;
	@FXML
	private Button img1Save, img2Save, img3Save;
	@FXML
	private Button img1Clear, img2Clear, Img3Clear, textClear;
	@FXML
	private ImageView img1, img2, img3;
	@FXML
	private TextArea textArea;

	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {

	}

	/**
	 * All Load buttons are associated with this method. This will call the load
	 * method according to the id.
	 *
	 * @param e
	 */
	@FXML
	public final void loadButton(final MouseEvent e) {
		Button buttonClicked = (Button) e.getSource();
		String id = buttonClicked.getId();
		System.out.println(id);
		if (id.contains("img")) {
			loadImage(id, e);
		}
		loadText();
	}

	/**
	 * Load text from file for textArea. call textFileChooserConfiguration for
	 * text format
	 *
	 */
	private void loadText() {
		final FileChooser fileChooser = new FileChooser();
		textFileChooserConfiguration(fileChooser);
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			BufferedReader input;
			try {
				String text = "";
				input = new BufferedReader(new FileReader(file));
				String line = input.readLine();
				while (line != null) {
					text = text + line + "\n";
					line = input.readLine();
				}
				System.out.println(text);
				textArea.setText(text);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	/**
	 * Format filter for fileChooser. choose editable text file only
	 *
	 * @param fileChooser
	 */
	private void textFileChooserConfiguration(FileChooser fileChooser) {
		fileChooser.setTitle("Load Text File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("txt", "*.txt"),
				new FileChooser.ExtensionFilter("Doc", "*.doc"),
				new FileChooser.ExtensionFilter("Docx", "*.docx"),
				new FileChooser.ExtensionFilter("rtf", "*.docx"),
				new FileChooser.ExtensionFilter("pages", "*.pages"),
				new FileChooser.ExtensionFilter("odt", "*.odt"));
	}

	private void loadImage(final String id, final Event e) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void saveButton(final Event e) {

	}

	/**
	 * Perform clear for multiple button events.
	 * Clear the node associate with button
	 * @param e
	 */
	@FXML
	public void clearButton(Event e) {
		Button buttonClicked = (Button) e.getSource();
		String id = buttonClicked.getId();		
		switch (id) {
		case "img1Clear": {
			img1 = new ImageView();
			break;
		}
		case "img2Clear": {
			img2 = new ImageView();
			break;
		}
		case "img3Clear": {
			img3 = new ImageView();
			break;
		}
		case "textClear": {
			textArea.setText(null);
			break;
		}
		default:
			break;

		}
	}

}
