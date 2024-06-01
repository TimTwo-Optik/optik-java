/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_palette;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Bagus
 */
public class RoundedPanel extends JPanel {
    private int cornerRadius = 15;

    public RoundedPanel() {
        super();
        setOpaque(false); // Make the panel transparent
    }

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
        setOpaque(false); // Make the panel transparent
    }
    
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Memastikan panel digambar ulang setelah perubahan
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 100); // Set the preferred size of the panel
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 50); // Set the minimum size of the panel
    }
}
