package org.pcgen.editor.gui;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class BuildableTreeSelectionListener implements TreeSelectionListener {
    private final TreeAction selectionAction;
    private final JTree jTree;

    public BuildableTreeSelectionListener(JTree jTree, TreeAction selectionAction) {
        this.selectionAction = selectionAction;
        this.jTree = jTree;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        //jTree.get
        TreePath selPath = e.getPath();
        int selRow = jTree.getRowForPath(selPath);

        if(selRow > -1){
            selectionAction.run(selRow, selPath);
        }
    }
}
