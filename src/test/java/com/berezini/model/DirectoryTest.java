package com.berezini.model;

import com.berezini.model.Category;
import com.berezini.model.Directory;
import com.berezini.model.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private Directory root;

    @BeforeEach
    void setUp() {
        root = new Directory("root", 1, Category.DOCUMENT);
    }

    @Test
    void testAddDirectory() {
        Directory dir = new Directory("documents", 2, Category.DOCUMENT);
        root.addDirectory(dir);
        assertTrue(root.getDirectories().contains(dir));
    }

    @Test
    void testAddMusicFile() {
        File file = new File("ACDC.mp3", 1, Category.MUSIC);
        root.addFile(file);
        assertTrue(root.getFiles().contains(file));
    }

    @Test
    void testRemoveDirectory() {
        Directory dir1 = new Directory("video", 2, Category.VIDEO);
        Directory dir2 = new Directory("temp", 3, Category.DOCUMENT);
        File file = new File("cv.txt", 1, Category.DOCUMENT);
        dir1.addDirectory(dir2);
        dir2.addFile(file);
        root.addDirectory(dir1);

        assertTrue(root.getDirectories().contains(dir1));
        assertTrue(dir1.getDirectories().contains(dir2));
        assertTrue(dir2.getFiles().contains(file));

        assertTrue(root.removeDirectory(2));

        assertFalse(root.getDirectories().contains(dir1));
        assertFalse(dir1.getDirectories().contains(dir2));
        assertFalse(dir2.getFiles().contains(file));
    }

    @Test
    void testRemoveFile() {
        File file1 = new File("poem.docx", 1, Category.DOCUMENT);
        File file2 = new File("arc.zip", 2, Category.ZIP);
        root.addFile(file1);
        root.addFile(file2);

        assertTrue(root.getFiles().contains(file1));
        assertTrue(root.getFiles().contains(file2));

        assertTrue(root.removeFile(1));

        assertFalse(root.getFiles().contains(file1));
        assertTrue(root.getFiles().contains(file2));
    }
}