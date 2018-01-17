package org.pcgen.editor.entry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import org.pcgen.editor.HasFile;

public class FileEntry implements Entry, HasFile
{
    private final File currentDir;
    private final File dataFolder;
    private final String extension;
    private String line;

    public FileEntry(String line, File currentDir, File dataFolder, String extension) {
        this.line = line;
        this.currentDir = currentDir;
        this.dataFolder = dataFolder;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public Component getEditor(JTree parentJTree) {
        String[] tokens = line.split(":");

        String tag = tokens[0];
        String value = line.substring(1 + tokens[0].length());

        File thisFile;
        if(isRelativeToData(value)){
            thisFile = getDataRelativeFile(value);
        } else {
            thisFile = getLocalFile(value);
        }

        JTextField editor =  new JTextField(value);
        editor.setEditable(false);

        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridBagLayout());

        GridBagConstraints tagConstraints = new GridBagConstraints();
        tagConstraints.fill = GridBagConstraints.HORIZONTAL;
        tagConstraints.gridx = 0;
        tagConstraints.gridy = 0;
        tagConstraints.weightx = 0;
        tagConstraints.insets = new Insets(5,15,5,15);
        jPanel3.add(new JLabel(tag), tagConstraints);

        JButton butBrowse = new JButton("Browse");
        butBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HOLY FUCK" );
            }
        });

        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.gridx = 1;
        inputConstraints.gridy = 0;
        inputConstraints.weightx = 100;
        jPanel3.add(editor, inputConstraints );

        GridBagConstraints browseButtonConstraints = new GridBagConstraints();
        browseButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        browseButtonConstraints.gridx = 2;
        browseButtonConstraints.gridy = 0;
        browseButtonConstraints.weightx = 0;
        browseButtonConstraints.insets = new Insets(5,15,5,15);
        jPanel3.add(butBrowse, browseButtonConstraints);

        editor.setBackground(Color.WHITE);
        editor.setForeground( new Color(0,75,0)); //CONSTANT!!! TODO

        JPanel jPanel2 = new DescriptionPanel("FUCK I FORGOT TO FIX THIS"); //TODO
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jPanel3, BorderLayout.PAGE_START);
        jPanel.add(jPanel2);

        return jPanel;
    }

    private File getLocalFile(String value) {
        return new File(currentDir.getPath().concat("/").concat(value));
    }

    private File getDataRelativeFile(String value) {
        return new File(dataFolder.getPath().concat(value.substring(1)));
    }

    private boolean isRelativeToData(String line) {
        return "@".equals(line.substring(0,1));
    }

    @Override
    public MutableTreeNode getNode() {
        return new DefaultMutableTreeNode(this);
    }

    @Override
    public String getToolTip() {
        return null;
    }

    private JFileChooser createJFileChooser(String rootFolder, String extension) {
        JFileChooser dialog;
        dialog = new JFileChooser(rootFolder);
        FileFilter filter = new FileNameExtensionFilter("FileEntry file", extension);
        dialog.setFileFilter(filter);
        return dialog;
    }
}
