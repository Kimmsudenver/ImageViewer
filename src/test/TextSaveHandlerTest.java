package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TextSaveHandler;

public class TextSaveHandlerTest {
	
	private static String TEST_FILE_NAME = "TestFileX9T5Q423KL.txt";
	
	private static String TEST_CONTENTS = "This is a test.\nMore tests.";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		TextSaveHandler handler = new TextSaveHandler(TEST_CONTENTS);
		File file = new File("./" + TEST_FILE_NAME);
		handler.save(file);
		String contents = readFile(file);
		assertEquals(TEST_CONTENTS, contents);
		file.delete();
	}

	private String readFile(File file) {
		StringBuilder text = new StringBuilder();
		if (file != null) {
			BufferedReader input;
			try {
				input = new BufferedReader(new FileReader(file));
				String line = input.readLine();
				while (line != null) {
					text.append(line);
					line = input.readLine();
					if (line != null) {
						text.append("\n");
					}
				}
			} catch (IOException e) {
				fail(e.getLocalizedMessage());
			}

		}
		return text.toString();
	}

}
