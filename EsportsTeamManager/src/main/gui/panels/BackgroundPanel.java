package main.gui.panels;

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
    private static final int INCREMENT = 5;

    private BufferedImage backgroundImage;

    private int dx1, dx2, dy;

    public BackgroundPanel() {
        initializeImages();
        initializeCoordinates();
        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBackground();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, dx1, dy, this);
        g.drawImage(backgroundImage, dx2, dy, this);
    }

    private void initializeCoordinates() {
        dx1 = 0;
        dx2 = 1600;
        dy = 0;
    }

    private void initializeImages() {
        try {
        	Image img = ImageIO.read(getClass().getResource(
            		GUIConstants.BACKGROUND_PLACEHOLDER)).getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
            backgroundImage = new BufferedImage(1600, 900, BufferedImage.TYPE_4BYTE_ABGR);
            backgroundImage.getGraphics().drawImage(img, 0, 0, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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