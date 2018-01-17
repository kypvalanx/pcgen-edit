package org.pcgen.editor.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.pcgen.editor.PcGenCellRenderer;
import org.pcgen.editor.file.Document;

public class Editor extends JFrame {
    private final JFileChooser dialog;
    private final JTabbedPane jTabbedPane;


    private File getDataFolder(final File file) {
        File dataFolder = file.getParentFile();//this may need to be a field
        while (true) {
            if ("data".equals(dataFolder.getName())) {
                break;
            }
            dataFolder = dataFolder.getParentFile();
        }
        return dataFolder;
    }

    public static void main(final String[] args)
    {
        new Editor(new CommandLineConfiguration(args));
    }

    private Editor(final Configuration configuration) {
        dialog = createJFileChooser(configuration);

        JPanel jPanel = new JPanel(new GridLayout(1, 1));

        jTabbedPane = new JTabbedPane();

        jPanel.add(jTabbedPane);
        jPanel.setOpaque(true);

        initThis(jPanel, createjMenuBar());

        pack();
        setVisible(true);
    }

    private JMenuBar createjMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.add(getOpenAction());
        file.add(getSaveAction());

        menuBar.add(file);
        return menuBar;
    }

    private AbstractAction getSaveAction() {
        return new AbstractAction("Save", new ImageIcon("save.gif")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                int focusedTabIndex = jTabbedPane.getSelectedIndex();
               // writeOutFile(currentFile);

            }
        };
    }

    private AbstractAction getOpenAction() {
        return new AbstractAction("Open", new ImageIcon("open.gif")) {
            public void actionPerformed(ActionEvent e) {
                dialog.setCurrentDirectory(new File("C:\\Users\\Thor_2\\git\\pcgen\\data\\pathfinder\\paizo"));
                if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File currentFile = dialog.getSelectedFile();
                        readInFile(currentFile);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
    }

    private JPanel createEditPanel() {
        JPanel editAreaPanel = new JPanel();
        editAreaPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        editAreaPanel.setLayout(new BorderLayout(5,5));
        editAreaPanel.setBackground(Color.gray);
        return editAreaPanel;
    }

    private JPanel createScrollPanel() {
        JPanel scrollPanel = new JPanel();
        scrollPanel.setBackground(Color.gray);
        scrollPanel.setBorder(BorderFactory.createBevelBorder(1));
        scrollPanel.setLayout(new BorderLayout());
        return scrollPanel;
    }

    private void initThis(JPanel jPanel, JMenuBar menuBar) {
        setJMenuBar(menuBar);
        add(jPanel);

        setBackground(Color.gray);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JFileChooser createJFileChooser(Configuration configuration) {
        JFileChooser dialog;
        dialog = new JFileChooser(configuration.getRootFolder());
        FileFilter filter = new FileNameExtensionFilter("FileEntry file", "pcc");
        dialog.setFileFilter(filter);
        return dialog;
    }

    private void readInFile(File file) throws IOException {
        int index = jTabbedPane.indexOfTab(file.getName());

        JPanel jPanel;

        if(isIndexNotNegative(index)) // ALREADY OPEN
        {
            if(shouldRefresh()) {

                jPanel = (JPanel) jTabbedPane.getComponentAt(index);
                jPanel.removeAll();

                openDocumentInTab(file, jPanel);
            }
            jTabbedPane.setSelectedIndex(index);
        } else { // not open

            jPanel = new JPanel(new GridLayout(0, 2));
            jTabbedPane.addTab(file.getName(), null, jPanel, file.getName());
            openDocumentInTab(file, jPanel);
        }

    }

    private void openDocumentInTab(File file, JPanel jPanel) throws IOException {
        Document document = Document.Factory.create(file);

        JPanel scrollPanel = createScrollPanel();
        JPanel editAreaPanel = createEditPanel();

        jPanel.add(scrollPanel);
        jPanel.add(editAreaPanel);

        JTree docTree = new JTree(document.getNode());
        docTree.setDragEnabled(true);


        docTree.addTreeSelectionListener(
                new BuildableTreeSelectionListener( docTree,
                        new EditValue(editAreaPanel, docTree)));

        docTree.setCellRenderer(new PcGenCellRenderer());

        JScrollPane scrollPane = new JScrollPane(docTree);
        scrollPanel.add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private boolean shouldRefresh() {
        return 0 == JOptionPane.showConfirmDialog(
                this,
                "Do you want to re-open the file?",
                "File Refresh?",
                JOptionPane.YES_NO_OPTION);
    }

    private boolean isIndexNotNegative(int index) {
        return index > -1;
    }

    private void writeOutFile(File currentFile) {
//        if(documentsByFile.get(currentFile).hasChanged()){}
//
//        if(!currentFile.getName().equals(this.openFileTree.getModel().getRoot()))
//        {
//            //currentFile.renameTo(new File(this.openFileTree.getModel().getRoot().toString()));
//        }
//        DefaultMutableTreeNode root = (DefaultMutableTreeNode) openFileTree.getModel().getRoot();
//        try {
//            currentFile.delete();
//            currentFile.createNewFile();
//            FileOutputStream fileOutputStream = new FileOutputStream(currentFile);
//
//            for (int i = 0; i < root.getChildCount(); i++){
//                DefaultMutableTreeNode child = (DefaultMutableTreeNode)root.getChildAt(i);
//                Object userObject = child.getUserObject();
//                if(userObject instanceof Lst || userObject instanceof FileEntry){
//                    writeOutFile(((HasFile)userObject).getFile());
//                }else {
//                    System.out.println(userObject.getClass());
//                }
//                //fileOutputStream.write(root.getChildAt(i).toString().getBytes());
//                System.out.println(root.getChildAt(i));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //System.out.println(this.openFileTree.getModel().getRoot().getClass());
        //System.out.println(this.openFileTree.getModel().getRoot());
//        try {
//            FileOutputStream outputStream = new FileOutputStream(currentFile);
//            System.out.println(this.openFileTree);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
