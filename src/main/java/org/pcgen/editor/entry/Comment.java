package org.pcgen.editor.entry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public class Comment implements Entry {
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    @Override
    public MutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }

    public Color getNonSelectionColor(){
        return new Color(50,205,50);
    }

    @Override
    public Color getNonSelectionBackgroundColor() {
        return Color.WHITE;
    }

    @Override
    public Color getSelectionColor() {
        return Color.WHITE;
    }

    @Override
    public Color getSelectionBackgroundColor() {
        return Color.blue;
    }

    @Override
    public String getToolTip() {
        return "COMMENT";
    }

    @Override
    public String toString(){
        return comment;
    }

    @Override
    public Component getEditor(final JTree parentJTree){
        JTextField editor =  new JTextField(comment.substring(1));
        editor.setBackground(Color.WHITE);
        editor.setForeground( new Color(0,75,0)); //CONSTANT!!! TODO

        JPanel jPanel2 = new DescriptionPanel("This is a comment and will not be read by PCGen.");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(editor, BorderLayout.PAGE_START);
        jPanel.add(jPanel2);
        editor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                comment = "#".concat(((JTextField)e.getComponent()).getText());
                ((DefaultTreeModel)parentJTree.getModel()).reload();
            }
        });
        return jPanel;
    }
}
