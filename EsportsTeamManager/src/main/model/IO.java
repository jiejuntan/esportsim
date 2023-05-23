package main.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Holds Input/Output functions
 * 
 * @author Blake and Jun
 *
 */
public final class IO {
	
	/**
	 * Reads a text that contains comma separated data from a file and returns it as a String Array
	 * 
	 * @param <CODE>String</CODE> filename file path
	 * @return <CODE>String[]</CODE>String Array of text
	 * @throws IOException	TODO
	 */
	public InputStream getFileFromResourceAsStream(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
	
    public String getString(InputStream is) {
        try (InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
        	return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
}
