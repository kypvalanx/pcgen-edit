package org.pcgen.editor;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.pcgen.editor.entry.Nodeable;

/**
 * Created by Thor_2 on 8/29/2017.
 */
public class PcGenCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean isSelected, boolean expanded, boolean leaf, int row,
                                                  boolean hasFocus) {
        JComponent c = (JComponent) super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
//        //JPanel c = new JPanel();
//        //c.setPreferredSize(new Dimension(tree.getWidth(), tree.getRowHeight()));
//
//        Dimension preferredSize = c.getPreferredSize();
//        c.setMinimumSize(preferredSize);
//        //System.out.println("orig "+preferredSize);
//
//        //prefferedSize.width = tree.getWidth();
//        //System.out.println("new  "+preferredSize);
//        c.setPreferredSize(preferredSize);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

        if(isSelected)
        {
            c.setForeground(((Nodeable) node.getUserObject()).getSelectionColor());
            c.setBackground(((Nodeable) node.getUserObject()).getSelectionBackgroundColor());
        }
        else
        {
            c.setForeground(((Nodeable) node.getUserObject()).getNonSelectionColor());
            c.setBackground(((Nodeable) node.getUserObject()).getNonSelectionBackgroundColor());
        }
        //String text = (String)((DefaultMutableTreeNode)value).getUserObject();
        //c.add(new JLabel(text));
        c.setOpaque(true);
        return c;
    }
}
