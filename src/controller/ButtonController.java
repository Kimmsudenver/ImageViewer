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

/**
 *
 * Buttons controller class. interact with window for all buttons, perform
 * various functionality associated with buttons
 *
 * @author Paul Ankenman
 * @author Guy Grigsby
 * @author Eric Van Gelder
 * @author Kiem Tech
 * @author Will Zirin
 * @author Aleksandr Gusan
 * @author Kim Bui
 *
 */

public class ButtonController implements javafx.fxml.Initializable {
	/** Connect to Buttons for Load images in fxml file. */
	@FXML
	private Button img1Load, img2Load, img3Load, textLoad;

	/** Connect to Buttons for save images in fxml file. */
	@FXML
	private Button img1Save, img2Save, img3Save, textSave;

	/**
	 * Connect to Buttons for clear images and text field in fxml file.
	 * */
	@FXML
	private Button img1Clear, img2Clear, Img3Clear, textClear;

	/** Connect to imageView in fxml file. */
	@FXML
	private ImageView img1, img2, img3;

	/** Connect to text field in fxml file. */
	@FXML
	private TextArea textArea;

	/**
	 * Required method to initialize. the controller
	 */
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
		} else {
			loadText();
		}
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
		fileChooser.setInitialDirectory(new File(System
				.getProperty("user.home")));
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
		Button buttonClicked = (Button) e.getSource();
		String id = buttonClicked.getId();
		ImageView current = null;
		if (id.contains("img")) {
			switch (id) {
			case "img1Save":
				current = img1;
				break;
			case "img2Save":
				current = img2;
				break;
			case "img3Save":
				current = img3;
				break;
			}
			saveImage(current);
		} else {
			saveText();
		}
	}

public void saveText() {
		BufferedWriter writeToFile = null;
		FileChooser fileChooser = new FileChooser();
		File fileChosen;
		
		if(textArea.getText() != null &&
		  (!textArea.getText().isEmpty())){
			
			fileChooser.setTitle("Save Text");
         fileChosen = fileChooser.showSaveDialog(null);
								
         if (fileChosen != null) {
				try {
                writeToFile = new BufferedWriter( new FileWriter(fileChosen));
    				 writeToFile.write(textArea.getText());
				}
				catch (IOException ex) {
				}
			   finally {
   				try {
        				if ( writeToFile != null) {
        					writeToFile.close( );
						}
    				}
    				catch ( IOException ex){
 					}
				}
			}
		}
		else {
			System.out.println("No text in the text box :( !");
		}
	}

	private void saveImage(ImageView imageView) {
		SaveHandler handler = new ImageSaveHandler(imageView);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Image");
		configureImageSaveDialog(fileChooser);
		File toFile = fileChooser.showSaveDialog(null);
		save(handler, toFile);	
	}
	
	private void save(SaveHandler handler, File file) {
		if (file != null) {
			handler.save(file);
		} else {
			//TODO display error
		}
		
	}



	private void configureImageSaveDialog(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System
				.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Files", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("BMP", "*.bmp"),
				new FileChooser.ExtensionFilter("GIF", "*.gif"));
	}

	/**
	 * Perform clear for multiple button events. Clear the node associate with
	 * button
	 *
	 * @param e
	 */
	@FXML
	public final void clearButton(Event e) {
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
