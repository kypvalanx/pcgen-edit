package org.pcgen.editor.entry;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DescriptionPanel extends JPanel{
    public DescriptionPanel(final String text) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new JLabel(text), BorderLayout.PAGE_START);
    }
}