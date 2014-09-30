package test;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.ImageSaveHandler;

public class ImageSaveHandlerTest {
	
	private ImageSaveHandler handler;

	@Before
	public void setUp() throws Exception {
		new JFXPanel(); // Initializes the JavaFx Platform
        final Image image = new Image(getClass().getResourceAsStream("../../img/cow.JPG"));
		handler = new ImageSaveHandler(image); 
	}

	@After
	public void tearDown() throws Exception {
		handler = null;
	}

	@Test
	public void testSave() {
		File file = new File("/home/guy/testSave.JPG");

		handler.save(file);

	}

}
