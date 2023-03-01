package com.berezini.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FileSystemIntegrationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testCreateAndDeleteCompareResult() {
        FileSystem fs = FileSystem.getInstance();
        fs.addDirectory("Music", 2, Category.MUSIC, 1);
        fs.addDirectory("Video", 3, Category.VIDEO, 1);
        fs.addDirectory("Documents", 4, Category.DOCUMENT, 1);
        fs.addDirectory("SASA", 6, Category.DOCUMENT, 4);
        fs.addDirectory("Songs", 5, Category.MUSIC, 2);
        fs.addDirectory("UUUU", 7, Category.MUSIC, 6);
        fs.addDirectory("aaaaa", 8, Category.MUSIC, 7);
        fs.addFile("Song1.mp3", 1, Category.MUSIC, 5);
        fs.addFile("music.flac", 4, Category.MUSIC, 7);
        fs.addFile("FileX.file", 3, Category.MUSIC, 1);
        fs.addFile("FileY.file", 5, Category.MUSIC, 1);
        fs.addFile("Song2.mp3", 2, Category.MUSIC, 5);
        fs.addFile("Document1.pdf", 3, Category.DOCUMENT, 4);
        fs.removeDirectory(6);
        fs.removeFile(3);
        fs.showAll();

        assertEquals("- root\n" +
                "    FileY.file\n" +
                "  - Music\n" +
                "    - Songs\n" +
                "        Song1.mp3\n" +
                "        Song2.mp3\n" +
                "  - Video\n" +
                "  - Documents\n" +
                "      Document1.pdf", outContent.toString().trim());
    }
}