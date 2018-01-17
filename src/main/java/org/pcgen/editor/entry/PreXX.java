package org.pcgen.editor.entry;

import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Thor_2 on 9/8/2017.
 */
public class PreXX implements Entry {
    private final String line;

    public PreXX(String line) {
        this.line = line;
    }

    @Override
    public DefaultMutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }

    @Override
    public String getToolTip() {
        return null;
    }

    @Override
    public String toString(){
        return line;
    }

    @Override
    public Component getEditor(JTree parentJTree) {
        return null;
    }
}
