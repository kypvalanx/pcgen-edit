package org.pcgen.editor.entry;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public class Empty implements Entry {

    public Color getNonSelectionColor(){
        return Color.lightGray;
    }

    @Override
    public String getToolTip() {
        return "";
    }

    @Override
    public String toString(){
        return "";
    }

    @Override
    public Component getEditor(final JTree parentJTree){
        return new JPanel();
    }

    @Override
    public MutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }
}
