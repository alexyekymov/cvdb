package com.github.alexyekymov.cvdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/github/alexyekymov/cvdb");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printDirectoryDeeply(dir);
    }

    static StringBuilder tab = new StringBuilder("");
    public static void printDirectoryDeeply(File dir) {

        File[] files = dir.listFiles();
        List<File> dirs = new ArrayList<>();

        System.out.println(tab + dir.getName());

        tab.append("\t");
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(tab.toString() + file.getName());
                }

                if (file.isDirectory()) {
                    dirs.add(file);
                }
            }
        }
        for (File file : dirs) {
            printDirectoryDeeply(file);
//            tab.delete(tab.length() - 2, tab.length() -1);
            tab.delete(1,2);
        }
    }
}
