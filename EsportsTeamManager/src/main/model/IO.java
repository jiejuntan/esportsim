package main.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Holds Input/Output functions
 * 
 * @author Blake and Jun
 *
 */
public final class IO {
	
	private static final String IMAGE_DIRECTORY = "/main/Resources/CharacterImage/";
	
	
	/**
	 * Reads a text that contains comma separated data from a file and returns it as a String Array
	 * 
	 * @param <CODE>String</CODE> filename file path
	 * @return <CODE>String[]</CODE>String Array of text
	 * @throws IOException	TODO
	 */
	public static String[] getTextFromFile(String filename) throws IOException {
		
		//Sets file path
		Path path = Paths.get(filename);
		
		//Reads the whole text into a string
		String textContent = Files.readString(path);
		
		// Split the string into individual names using a comma delimiter
	    String[] textArray = textContent.split(",");
	    
		
		return textArray;
	}
	
	/**
	 * Randomly pick a image from the CharactersImages Directory
	 * 
	 * @return <CODE>String</CODE> path of image
	 */
	 public static String getRandomImagePath() {
	        Random rand = new Random();
	        
	        // Generate a random number between 1 and totalNumberOfImages
	        int randomImageNumber = rand.nextInt(1, 67);
	        
	        // Build the image path
	        String imagePath = IMAGE_DIRECTORY + randomImageNumber + ".png";
	       	        
	        return imagePath;
	    }
	

}
