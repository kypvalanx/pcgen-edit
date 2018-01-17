package org.pcgen.editor.util;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;

public class FileLineReaderTest
{
    @Test
    public void readNullPath() throws IOException
    {
        List<String> list = FileLineReader.read(null);

        assertThat(list, is(empty()));
    }
    @Test
    public void readEmptyPath() throws IOException
    {
        List<String> list = FileLineReader.read(new File("src/test/resources/core_rulebook copy.pcc"));

        assertThat(list, hasSize(116));
    }
}