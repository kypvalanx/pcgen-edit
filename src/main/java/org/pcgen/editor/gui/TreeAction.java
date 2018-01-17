package org.pcgen.editor.gui;

import javax.swing.tree.TreePath;

public interface TreeAction {
    default void run(int selRow, TreePath selPath){
        System.out.println("Unused Clickaction");
    }
}
