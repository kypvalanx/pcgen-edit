package org.pcgen.editor.gui;

public interface Configuration {
    default String getRootFolder(){
        return System.getProperty("user.dir");
    }
}
