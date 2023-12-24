package org.example;

import org.example.lib.Serializer;
import org.example.tasks.Task;
import org.example.tasks.TaskManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager tasks = new TaskManager();
        String saveFilePath = "/home/" + System.getProperty("user.name") + "/.cache/TJM/data.ser";

        System.out.println("Welcome to Java Task Manager, or JTM. Type h for help.");

        programLoop:
        while (true) {
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "n":
                    System.out.println("Okay, what's the task?");
                    String newTaskContent = scanner.nextLine();
                    tasks.addTask(new Task(newTaskContent));
                    System.out.println("Perfect, here is your new list of tasks:");
                    for(Task task : tasks.getTasks()) {
                        System.out.println(task.toString());
                    }
                    break;
                case "l":
                    List<Task> taskList = tasks.getTasks();
                    System.out.println("| Idx | Task Info  ");
                    System.out.println("|-----|------------");
                    for (int i = 0; i < taskList.size(); i++) {
                        String paddedIndex = String.format("%-" + 4 + "s", i);
                        System.out.println("| " + paddedIndex + "| " + ((List<?>) taskList).get(i).toString());
                    }
                    break;
                case "la":
                    for(Task task : tasks.getAllTasks()) {
                        System.out.println(task.toString());
                    }
                    break;
                case "s":
                    Serializer.serialize(tasks, saveFilePath);
                    System.out.println("Saved data to disk at " + saveFilePath);
                    break;
                case "h":
                    // Print the help message
                    System.out.println("""
                            Java Task Manager Help:
                            -----------------------
                            Commands:
                              n - Add a new task
                              l - List incomplete tasks
                             la - List all tasks, including completed
                              s - Save current TaskManager and Tasks to disk
                              h - Show this help message
                              q - Quit the program""");
                    break;
                case "q":
                    break programLoop;
                default:
                    System.out.println("That is not a known command. Please type h for help.");
            }
        }

        scanner.close();
    }
}
