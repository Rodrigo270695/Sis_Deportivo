package com.deportivo.properties;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean bln, boolean bln1, int i, int i1) {
        if (o instanceof JButton boton) {
            return boton;
        }
        if (o instanceof JLabel lbl) {
            return lbl;
        }

        return super.getTableCellRendererComponent(jTable, o, bln, bln1, i, i1);
    }

}
