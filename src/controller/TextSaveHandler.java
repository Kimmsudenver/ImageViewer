package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TextSaveHandler implements SaveHandler {
	
	private String contents;
	
	public TextSaveHandler(String toSave) {
		contents = toSave;
	}
	@Override
	public void save(File file) {

		try (PrintWriter out = new PrintWriter(file);) {
			if (!file.exists()) {
				file.createNewFile();
			}
			out.print(contents);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
