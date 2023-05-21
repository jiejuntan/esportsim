package main.gui.panels.subclassable;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.gui.GUIConstants;

/**
 * Subclassable moving background panel
 * 
 * @author Jiejun Tan
 *
 */
public class BackgroundPanel extends JPanel {
	
	/**
	 * Background horizontal speed
	 */
    private static final int INCREMENT = 5;

    /**
     * Background image
     */
    private BufferedImage backgroundImage;

    /**
     * Coordinates
     */
    private int dx1, dx2, dy;

    /**
     * Constructor for background panel
     */
    public BackgroundPanel() {
        initializeImages();
        initializeCoordinates();
        setTimer();
    }

    /**
     * Paints background
     */
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, dx1, dy, this);
        g.drawImage(backgroundImage, dx2, dy, this);
    }

	/**
	 * Load background and format
	 */
	private void initializeImages() {
        try {
        	Image img = ImageIO.read(getClass().getResource(
            		GUIConstants.BACKGROUND_ANIMATED)).getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
            backgroundImage = new BufferedImage(1600, 900, BufferedImage.TYPE_4BYTE_ABGR);
            backgroundImage.getGraphics().drawImage(img, 0, 0, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	/**
	 * Sets initial coordinates of background image
	 */
    private void initializeCoordinates() {
        dx1 = 0;
        dx2 = 1600;
        dy = 0;
    }

    /**
     * Creates and starts timer to call move background method
     */
    private void setTimer() {
    	Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBackground();
                repaint();
            }
        });
        timer.start();
	}

    /**
     * Moves background by manipulating coordinates
     */
    private void moveBackground() {
        if (dx1 <= -1600) {
        	dx1 = 1600;
        } else if (dx2 <= -1600) {
        	dx2 = 1600;
        } else {
        	dx1 -= INCREMENT;
        	dx2 -= INCREMENT;
        }
    }
}