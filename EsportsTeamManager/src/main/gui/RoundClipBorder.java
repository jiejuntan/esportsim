package main.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

/**
 * Creates round borders, modified from StackOverflow
 * 
 * @author Jiejun Tan
 */
public class RoundClipBorder extends AbstractBorder {

    private Color color;
    private int thickness;
    private int radius;
    private Insets insets;
    private BasicStroke stroke;
    private int strokePad;
    RenderingHints hints;

    public RoundClipBorder(Color color, int thickness, int radius) {
        this.thickness = thickness;
        this.radius = radius;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int xPad = 10 + strokePad;
        int yPad = 2 + strokePad;
        insets = new Insets(yPad, xPad, strokePad, xPad);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x, int y,
            int width, int height) {

        Graphics2D g2 = (Graphics2D) g;

        int bottomLineY = height - thickness;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY,
                radius,
                radius);


        Area area = new Area(bubble);

        g2.setRenderingHints(hints);

        Component parent  = c.getParent();
        if (parent != null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0, 0, width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }
        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}