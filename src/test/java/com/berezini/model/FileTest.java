package com.berezini.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileTest {

    @Test
    public void testConstructor() {
        File file = new File("example.txt", 123456789, Category.DOCUMENT);
        assertEquals("example.txt", file.getName());
        assertEquals(123456789, file.getId());
        assertEquals(Category.DOCUMENT, file.getCategory());
    }
}