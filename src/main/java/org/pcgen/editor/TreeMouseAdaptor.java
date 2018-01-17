package org.pcgen.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public class TreeMouseAdaptor extends MouseAdapter {
    private final JTree tree;
    private final Clickable clickable;

    public TreeMouseAdaptor(JTree tree, Clickable clickable){
        this.tree = tree;
        this.clickable = clickable;
    }

    public void mousePressed(MouseEvent e) {
        int selRow = tree.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getButton() == 1) {
                if (e.getClickCount() == 1) {
                    clickable.mySingleClick(selRow, selPath);
                } else if (e.getClickCount() == 2) {
                    clickable.myDoubleClick(selRow, selPath);
                }
            } else if (e.getButton() == 2){
                clickable.myRightClick(selRow, selPath);
            }
        }
    }
}
