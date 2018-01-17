package org.pcgen.editor.entry;

import java.io.File;
import java.io.IOException;

/**
 * Created by Thor_2 on 8/19/2017.
 */
public class LstEntryFactory {

    private final File currentFile;

    public LstEntryFactory(File currentFile){
        this.currentFile = currentFile;
    }

    public Entry create(String line) throws IOException {
        //Check for empty lines
        if (null == line || line.isEmpty()) {
            return new Empty();
        }
        //Check for comments
        if (line.charAt(0) == '#') {
            return new Comment(line);
        }


        String[] tokens = line.split(":");
        switch (tokens[0]) {
            case "ABILITY":
            default:
                return new Unknown(line);
        }
    }
}
