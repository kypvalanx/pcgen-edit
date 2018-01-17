package org.pcgen.editor.entry;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public class Unknown implements Entry {
    private String string;

    public Unknown(String string) {
        this.string = string;
    }

    @Override
    public DefaultMutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }

    @Override
    public Color getNonSelectionColor(){
        return Color.WHITE;
    }

    @Override
    public Color getNonSelectionBackgroundColor(){
        return Color.RED;
    }

    @Override
    public Color getSelectionColor() {
        return Color.RED;
    }

    @Override
    public Color getSelectionBackgroundColor() {
        return Color.BLACK;
    }

    @Override
    public String getToolTip() {
        return "This is an unrecognized entry.";
    }

    @Override
    public String toString(){
        return string;
    }

    @Override
    public Component getEditor(JTree parentJTree) {
        JTextArea jTextArea = new JTextArea(toString());
        jTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                string = jTextArea.getText();
            }
        });
        return jTextArea;
    }
}
