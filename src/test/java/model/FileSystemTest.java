package model;

import com.berezini.model.Directory;
import com.berezini.model.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.berezini.model.Category;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    private FileSystem fileSystem;

    @BeforeEach
    void setUp() {
        fileSystem = FileSystem.getInstance();
    }

    @Test
    void testAddAndRemoveDirectory() {
        // Add a new directory to the root directory
        fileSystem.addDirectory("newDir", 2, Category.DOCUMENT, 1);

        // Remove directory
        assertNotNull(fileSystem.removeDirectory(2));
        fileSystem.showAll();
    }

    @Test
    void testAddAndRemoveFile() {
        // Add a new file to the root directory
        fileSystem.addFile("doc.txt", 1, Category.DOCUMENT, 1);

        // Remove file
        assertTrue(fileSystem.removeFile(1));
    }

    @Test
    void testFindDirectoryFatherById() {
        // Add a new directory to the root directory
        fileSystem.addDirectory("three", 2, Category.DOCUMENT, 1);

        // Find the parent directory of the new directory by id
        Directory dir = fileSystem.findDirectoryFatherById(2);

        // Check that the returned directory has the correct name
        assertEquals("root", dir.getName());
    }
}