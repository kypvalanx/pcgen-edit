package org.pcgen.editor.entry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ShortStringEntry implements Entry {
    private String line;
    private final String shortDescription;
    private final String longDescription;

    public ShortStringEntry(String line, String shortDescription, String longDescription) {
        this.line = line;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    @Override
    public Component getEditor(final JTree parentJTree) {
        String[] tokens = line.split(":");

        String tag = tokens[0];
        String value = line.substring(1 + tokens[0].length());

        JTextField editor =  new JTextField(value);

        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridBagLayout());

        GridBagConstraints tagConstraints = new GridBagConstraints();
        tagConstraints.fill = GridBagConstraints.HORIZONTAL;
        tagConstraints.gridx = 0;
        tagConstraints.gridy = 0;
        tagConstraints.weightx = 0;
        tagConstraints.insets = new Insets(5,15,5,15);
        jPanel3.add(new JLabel(tag), tagConstraints);


        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.gridx = 1;
        inputConstraints.gridy = 0;
        inputConstraints.weightx = 100;
        jPanel3.add(editor, inputConstraints );

        editor.setBackground(Color.WHITE);
        editor.setForeground( new Color(0,75,0)); //CONSTANT!!! TODO


        JPanel jPanel2 = new DescriptionPanel(longDescription);
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jPanel3, BorderLayout.PAGE_START);
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
                line = tag.concat(":").concat(((JTextField)e.getComponent()).getText());
                ((DefaultTreeModel)parentJTree.getModel()).reload();
            }
        });
        return jPanel;
    }

    @Override
    public DefaultMutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }


    @Override
    public String getToolTip() {
        return shortDescription;
    }

    @Override
    public String toString(){
        return line;
    }
}
