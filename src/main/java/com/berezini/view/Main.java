package com.berezini.view;

import com.berezini.model.Category;
import com.berezini.model.FileSystem;

public class Main {
    public static void main(String[] args) {
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
        fs.showAll();
        fs.removeDirectory(6);
        fs.removeFile(3);
        System.out.println("Result after remove");
        fs.showAll();
    }
}
