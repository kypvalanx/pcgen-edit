package org.pcgen.editor.file;

import org.pcgen.editor.entry.Entry;
import org.pcgen.editor.entry.PCCEntryFactory;
import org.pcgen.editor.util.FileLineReader;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thor_2 on 9/15/2017.
 */
public class PCCDocument implements Document {
    private final ArrayList<Entry> entries;
    private final DefaultMutableTreeNode node;
    private File file;

    public PCCDocument(File file) throws IOException {
        List<String> lines = FileLineReader.read(file);

        File dataFolder = getDataFolder(file);

        entries = new ArrayList<>(lines.size());
        PCCEntryFactory pccEntryFactory = new PCCEntryFactory(file.getParentFile(), dataFolder);

        this.node = new DefaultMutableTreeNode(this);
        for (String line : lines) {
            node.add(pccEntryFactory.create(line).getNode());
        }

        this.file = file;
    }

    private File getDataFolder(File file) {
        File dataFolder = file;

        while (dataFolder.exists()) {
            if ("data".equals(dataFolder.getName())) {
                break;
            }
            dataFolder = dataFolder.getParentFile();
        }
        return dataFolder;
    }

    @Override
    public MutableTreeNode getNode() {
        return node;
    }

    @Override
    public String getToolTip() {
        return null;
    }

    @Override
    public boolean hasChanged() {
        return true;
    }

    @Override
    public String toString() {
        return file.getName();
    }

    public Component getEditor(final JTree parentJTree) {

        JTextArea editor = new JTextArea(file.getAbsolutePath());

        editor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                String retrievedText = ((JTextArea) e.getComponent()).getText();
                if (retrievedText != null && !retrievedText.isEmpty() && !file.getAbsolutePath().equals(retrievedText)) {
                    File newFile = new File(retrievedText);
                    String[] options = {"Yes", "No"};
                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure that you want to rename " + file.getAbsolutePath() + " to "
                                    + newFile.getAbsolutePath() + "?",
                            "Are you sure?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (result == 0) {
                        if (file.renameTo(newFile)) {
                            file = newFile;
                        } else {
                            System.out.println("file could not be renamed");
                        }
                    }
                }
            }
        });
        return editor;
    }
}
