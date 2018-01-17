package org.pcgen.editor.entry;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import javax.swing.JTree;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.pcgen.editor.jcomponent.JStaticKeyPairs;

/**
 * Created by Thor_2 on 8/28/2017.
 */
public class URLValue implements Entry {

    private String value;
    private DefaultMutableTreeNode node;

    public URLValue(String value) {
        this.value = value;
        node = new DefaultMutableTreeNode(this);
    }

    @Override
    public DefaultMutableTreeNode getNode() {
        return node;
    }

    public Color getNonSelectionColor(){
        return new Color(50,50,205);
    }

    @Override
    public String getToolTip() {
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public Component getEditor(final JTree parentJTree){
        String[] tokens = value.split(":", 2);
        String[] subtokens = tokens[1].split("\\|", 3);
        List<Pair<String,String>> values = new ArrayList<>(3);
        values.add(new Pair<>("E-commerce site name|WEBSITE|SURVEY",subtokens[0]));
        values.add(new Pair<>("Hyperlink",subtokens[1]));
        values.add(new Pair<>("Link Description",subtokens[2]));

        //System.out.println(new ArrayList<String>(data).toString());
        JStaticKeyPairs editor = new JStaticKeyPairs(values);
        editor.addPropertyChangeListener(evt -> {
            if ("tableCellEditor".equals(evt.getPropertyName()))
            {
                if(!editor.isEditing()) {
                    TableModel tableModel = editor.getModel();
                    value = tokens[0].concat(":").concat(tableModel.getValueAt(0,1).toString()).concat("|")
                            .concat(tableModel.getValueAt(1,1).toString()).concat("|")
                            .concat(tableModel.getValueAt(2,1).toString());
                    parentJTree.repaint();
                }
            }
        });
        return editor;
    }
}
