package main.gui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Music player class
 * 
 * @author Jiejun Tan
 *
 */
public final class Music {
	
	/**
	 * Sound clip
	 */
    Clip clip;
    
    /**
     * Input stream
     */
    AudioInputStream sound;
    
    /**
     * Sets audio file
     * 
     * @param soundFileName	path of audio clip
     */
    public void setFile(String soundFileName) {
        try {
            File file = new File(this.getClass().getResource(soundFileName).toURI());
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
        }
    }
    
    /**
     * Plays audio continuously.
     */
    public void play() {
    	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /**
     * Stops audio
     * @throws IOException if interrupted
     */
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }
}