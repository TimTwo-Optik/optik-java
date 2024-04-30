/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_palette;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Bagus
 */
public class ComboBoxListCellRender extends DefaultListCellRenderer {
    
    private ArrayList<Integer> targetIndices;
    
    // Konstruktor untuk mengatur indeks target
    public ComboBoxListCellRender(ArrayList<Integer> targetIndices) {
        this.targetIndices = targetIndices;
    }

    // Metode untuk menambah indeks target
    public void addTargetIndex(int targetIndex) {
        this.targetIndices.add(targetIndex);
    }

    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      
        if (value != null) {
             if (targetIndices.contains(index)) {
                c.setFont(getFont().deriveFont(Font.BOLD));
            }
        }

        return c;
    }
}
