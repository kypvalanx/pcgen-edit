package org.pcgen.editor.gui;

import javax.swing.tree.TreePath;
import org.pcgen.editor.Clickable;

public class ThreeClickClickable implements Clickable {
    private final TreeAction singleClick;
    private final TreeAction doubleClick;
    private final TreeAction rightClick;

    public ThreeClickClickable(TreeAction singleClick, TreeAction doubleClick, TreeAction rightClick) {
        this.singleClick = singleClick;
        this.doubleClick = doubleClick;
        this.rightClick = rightClick;
    }

    @Override
    public void mySingleClick(int selRow, TreePath selPath) {
        if (singleClick != null) {
            singleClick.run(selRow, selPath);
        }
    }

    @Override
    public void myDoubleClick(int selRow, TreePath selPath) {
        if (doubleClick != null) {
            doubleClick.run(selRow, selPath);
        }
    }

    @Override
    public void myRightClick(int selRow, TreePath selPath) {
        if (rightClick != null) {
            rightClick.run(selRow, selPath);
        }
    }
}
