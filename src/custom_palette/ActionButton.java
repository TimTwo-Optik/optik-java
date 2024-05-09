/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_palette;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Bagus
 */
public class ActionButton extends JButton {
    
    private boolean mousePress;
    
    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePress = false; 
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(10, 10);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        
        if(mousePress) {
            g2d.setColor(new Color(160, 190, 158));
        } else {
            g2d.setColor(new Color(175, 200, 173));
        }
        
        g2d.fillRoundRect(2, 2, width-4, height-4, arcs.width, arcs.height);
        g2d.drawRoundRect(2, 2, width-4, height-4, arcs.width, arcs.height);
        super.paintComponent(g);
    }
    
    
}
