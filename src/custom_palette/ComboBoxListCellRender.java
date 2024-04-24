/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_palette;

import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Bagus
 */
public class ComboBoxListCellRender extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      
        if (value != null) {
            if("Jenis Supplier".equals(value.toString()) || "Lokasi".equals(value.toString())){
                setFont(getFont().deriveFont(Font.BOLD));
            }
            
        }

        return c;
    }
}
