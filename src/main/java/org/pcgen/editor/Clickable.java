package org.pcgen.editor;

import javax.swing.tree.TreePath;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public interface Clickable {
    void mySingleClick(int selRow, TreePath selPath);

    void myDoubleClick(int selRow, TreePath selPath);

    void myRightClick(int selRow, TreePath selPath);
}
