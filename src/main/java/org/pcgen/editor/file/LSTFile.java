package org.pcgen.editor.file;

/**
 * Created by Thor_2 on 9/15/2017.
 */
public class LSTFile {
    public LSTFile(String line) {
    }

//    public static Entry create(String line, File dataFolder, File currentFile) throws IOException {
//        String[] tokens = line.split(":");
//
//        String pathName;
//        if(tokens[1].contains("@"))
//        {
//            pathName = tokens[1].split("\\|")[0].replace("/","\\").replace("@", dataFolder.getAbsolutePath());
//        } else {
//            pathName = currentFile.getParentFile().getAbsolutePath()+"\\"+ tokens[1].split("\\|")[0].replace("/","\\");
//        }
//
//        File lst = new File(pathName);
//
//        List<String> lines = FileLineReader.read(lst);
//
//        List<Entry> entries = new ArrayList<>(lines.size());
//
//        return new Lst(lst.getName(),entries);
//    }
}
