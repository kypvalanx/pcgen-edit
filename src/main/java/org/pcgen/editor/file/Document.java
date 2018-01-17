package org.pcgen.editor.file;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.pcgen.editor.entry.Entry;

public interface Document extends Entry {
    boolean hasChanged();

    class Factory {
        public static Document create(File file) throws IOException {
            switch (FilenameUtils.getExtension(file.getName()).toUpperCase())
            {
                case "PCC":
                    return new PCCDocument(file);
                case "LST":
                default:
                    throw new IllegalArgumentException("UNSUPPORTED FILE TYPE");
            }
        }
    }
}
