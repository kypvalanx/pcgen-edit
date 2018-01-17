package org.pcgen.editor.entry;

import java.awt.Color;
import javax.swing.tree.MutableTreeNode;

public interface Nodeable {
    MutableTreeNode getNode();

    default Color getNonSelectionColor() {
        return Color.black;
    }

    default Color getNonSelectionBackgroundColor() {
        return Color.white;
    }

    default Color getSelectionColor() {
        return Color.white;
    }

    default Color getSelectionBackgroundColor() {
        return Color.blue;
    }

    String getToolTip();
}
