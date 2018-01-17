package org.pcgen.editor.entry;

import java.awt.Component;
import javax.swing.JTree;


/**
 * Created by Thor_2 on 8/19/2017.
 */
public interface Entry extends Nodeable {

    Component getEditor(final JTree parentJTree);
}
