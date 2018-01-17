package org.pcgen.editor.jcomponent;

import java.awt.Color;
import java.util.List;
import javafx.util.Pair;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JStaticKeyPairs extends JTable {
    public JStaticKeyPairs(List<Pair<String, String>> list) {
        super(list.size(),2);
        setVisible(true);
        setTableHeader(null);
        getColumnModel().getColumn(0).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JLabel component = (JLabel) new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);

            switch (column){
                case 0:
                    component.setBackground(Color.lightGray);
                    component.setBorder(BorderFactory.createRaisedBevelBorder());
                    break;
                default:
                    component.setBackground(Color.WHITE);
                    break;
            }

            return component;
        });
        for(int i = 0; i < list.size(); i++){
            Pair<String, String> pair = list.get(i);
            this.setValueAt( pair.getKey(),i,0);
            this.setValueAt( pair.getValue(), i,1);
        }
    }
    @Override
    public boolean isCellEditable(final int row, final int column){
        switch (column){
            case 1:
                return true;
            default:
                return false;
        }

    }
}
