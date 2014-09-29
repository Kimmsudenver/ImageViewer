package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

public class ImageSaveHandler implements SaveHandler {
	
	private ImageView imageView;
	
	private Image image;
	
	public ImageSaveHandler(ImageView view) {
		this(view.getImage());
		imageView = view;
	}
	
	public ImageSaveHandler(Image im) {
		image = im;
	}
	@Override
	public void save(File file) {
	    try {
	    	String ext = getFileExtension(file);
	    	BufferedImage tempImg = SwingFXUtils.fromFXImage(image, null);
			ImageIO.write(tempImg, (ext == null ? "JPG" : ext), file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}
	
	private String getFileExtension(File file) {
		String fileName = file.getName();
		int extStart = fileName.lastIndexOf('.');
		if (extStart < 0) {
			return null;
		}
		return fileName.substring(extStart + 1);
	}

	public void load() {
		imageView.setImage(new Image(getClass().getResourceAsStream("../test/cow.JPG")));
	}
	

}
