package org.pcgen.editor.gui;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.pcgen.editor.entry.Entry;

public class EditValue implements TreeAction {
    private final JPanel editAreaPanel;
    private final JTree openFileTree;

    public EditValue(JPanel editAreaPanel, JTree openFileTree) {
        this.editAreaPanel = editAreaPanel;
        this.openFileTree = openFileTree;
    }

    @Override
    public void run(int selRow, TreePath selPath) {
        editAreaPanel.removeAll();
        Component editor = ((Entry) ((DefaultMutableTreeNode) selPath.getLastPathComponent()).getUserObject()).getEditor(openFileTree);
        editAreaPanel.add(editor);
        editAreaPanel.revalidate();
        editAreaPanel.repaint();
    }
}
