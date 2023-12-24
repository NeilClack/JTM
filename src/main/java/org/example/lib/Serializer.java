package org.example.lib;

import java.io.*;

public class Serializer {
    public static void serialize(Object object, String filepath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            System.out.println("Saving data...");
            outputStream.writeObject(object);
            System.out.println("Successfully Saved!");
        } catch (FileNotFoundException e) {
            System.out.println("No save file found, creating...");
            createFile(filepath);
            serialize(object, filepath);
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
            e.printStackTrace();
        }
    }

    public static <T> T deserialize(String filepath, Class<T> type) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filepath))) {
            return type.cast(inputStream.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("No save file found at that location: " + filepath);
            return null;
        } catch (IOException e) {
            System.out.println("Unable to read data from file. ");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Your developer has made a grave mistake, probably. See the Stack Trace!");
            return null;
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
