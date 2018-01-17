package org.pcgen.editor.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileLineReader
{
    public static List<String> read(File file) throws IOException
    {
        if(file == null)
        {
            return Collections.emptyList();
        }
        try{
            return Files.lines(file.toPath(), StandardCharsets.UTF_8).collect(Collectors.toList());
        }catch (Exception e){

            try{
                return Files.lines(file.toPath(), StandardCharsets.ISO_8859_1).collect(Collectors.toList());
            }catch (Exception e2){
                e.printStackTrace();
                e2.printStackTrace();
                return Collections.emptyList();
            }
        }
    }
}
