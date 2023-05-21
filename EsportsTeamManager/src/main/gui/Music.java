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
public class Music {
	
    Clip clip;
    AudioInputStream sound;
    
    public void setFile(String soundFileName) {
        try {
            File file = new File(this.getClass().getResource(soundFileName).toURI());
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
        }
    }
    
    public void play() {
    	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }
}