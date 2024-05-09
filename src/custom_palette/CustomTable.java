/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_palette;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Bagus
 */
public class CustomTable extends JTable {

    private TableHeader header;
    private TableCell cell;

    public CustomTable() {
        header = new TableHeader();
        cell = new TableCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 62));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(62);
        setSelectionBackground(new Color(160,190,15));
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new CustomScrollBar());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(136, 171, 142));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(242, 241, 235));
    }

    private class TableHeader extends DefaultTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(136, 171, 142));
            com.setForeground(new Color(242, 242,242));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 14));
            setHorizontalAlignment(SwingConstants.CENTER);
            
            return com;
        }
    }

    private class TableCell extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isCellSelected(row, column)) {
                com.setBackground(new Color(160, 190, 158));
                com.setForeground(new Color(242, 242,242));
            } else {
               com.setBackground(new Color(242, 241, 235));
               com.setForeground(new Color(50, 50, 50));
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            setHorizontalAlignment(SwingConstants.CENTER);
            return com;
        }
    }
}
