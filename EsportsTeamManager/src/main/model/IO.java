package main.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO {
	
	
	/**
	 * Reads a text that contains comma separated data from a file and returns it as a String Array
	 * 
	 * @param filename		file path
	 * @return 				String Array of text
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
	

}
