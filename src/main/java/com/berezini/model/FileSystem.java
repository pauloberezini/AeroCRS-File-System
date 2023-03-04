package com.berezini.model;

public class FileSystem implements IOrganized {
    private static FileSystem instance = null;
    private static Directory root;

    private FileSystem() {
        root = new Directory("root", 1, Category.DOCUMENT);
    }

    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void addDirectory(String name, long directoryId, Category category, long parentDirectoryId) {
        try {
            Directory parentDirectory = findDirectoryById(root, parentDirectoryId);
            if (parentDirectory != null) {
                Directory directory = new Directory(name, directoryId, category);
                parentDirectory.addDirectory(directory);
            } else {
                System.out.println("Parent directory not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addFile(String name, long id, Category category, long parentDirectoryId) {
        try {
            Directory parentDirectory = findDirectoryById(root, parentDirectoryId);
            if (parentDirectory != null) {
                File file = new File(name, id, category);
                parentDirectory.addFile(file);
            } else {
                System.out.println("Parent directory not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean removeDirectory(long id) {
        try {
            if (id == 1) {
                System.out.println("Cannot delete root directory");
                return false;
            } else {
                Directory father = findDirectoryFatherById(id);
                father.removeDirectory(id);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeFile(long id) {
        return root.removeFile(id);
    }

    public void showAll() {
        root.showAll(0);
    }

    public Directory findDirectoryById(Directory directory, long id) {
        try {
            if (directory.getId() == id) {
                return directory;
            } else {
                for (Directory dir : directory.getDirectories()) {
                    Directory result = findDirectoryById(dir, id);
                    if (result != null) {
                        return result;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Directory findDirectoryFatherById(long id) {
        try {
            for (Directory dir : root.getDirectories()) {
                if (dir.getId() == id && root.getId() == 1) {
                    return root;
                }
                Directory result = findDirectoryById(dir, id);
                if (result != null) {
                    return dir;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}