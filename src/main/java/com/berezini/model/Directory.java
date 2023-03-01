package com.berezini.model;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractData implements Organized {
    private List<Directory> directories;
    private List<File> files;

    public Directory(String name, long id, Category category) {
        super(name, id, category);
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public List<File> getFiles() {
        return files;
    }

    @Override
    public boolean removeDirectory(long id) {
        for (int i = 0; i < directories.size(); i++) {
            Directory dir = directories.get(i);

            for (int k = 0; k < dir.files.size(); k++) {
                File file = dir.files.get(k);
                dir.removeFile(file.getId());
            }
            if (dir.directories.size() > 0) {
                for (int j = 0; j < dir.getDirectories().size(); j++) {
                    Directory subdir = dir.getDirectories().get(j);
                    dir.removeDirectory(subdir.getId());
                }
            }
            // Remove the directory itself
            directories.remove(dir);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFile(long id) {
        for (File file : files) {
            if (file.getId() == id) {
                files.remove(file);
                return true;
            }
        }
        return false;
    }


    public void showAll(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + super.getName());

        for (File file : files) {
            for (int i = 0; i < level + 2; i++) {
                System.out.print("  ");
            }
            System.out.println(file.getName());
        }

        for (Directory dir : directories) {
            dir.showAll(level + 1);
        }
    }
}