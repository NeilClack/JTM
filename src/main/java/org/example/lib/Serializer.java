package org.example.lib;

import org.example.tasks.TaskManager;

import java.io.*;

public class Serializer {
    public static void serialize(Object object, String filepath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            outputStream.writeObject(object);
        } catch (FileNotFoundException e) {
            System.out.println("No save file found, creating...");
            createFile(filepath);
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
            e.printStackTrace();
        }
    }

    private static void createFile(String filepath) {
        File file = new File(filepath);
        File parentDir = file.getParentFile();

        try {
            // Create parent directories if they don't exist
            if (!parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Created parent directories: " + parentDir);
                } else {
                    System.out.println("Failed to create parent directories.");
                }
            }
            if(file.createNewFile()) {
                System.out.println("Created new save file: " + filepath);
            } else {
                System.out.println("Save file found, skipping create.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when creating the save file.");
            e.printStackTrace();
        }
    }
}
