package org.example.tasks;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.Serializable;

/**
 * The TaskManager class manages a collection of tasks.
 * It provides methods for adding tasks to the collection and retrieving the list of tasks.
 */
public class TaskManager implements Serializable {
    /**
     * The list of tasks managed by the TaskManager.
     */
    private List<Task> tasks;

    /**
     * Constructs a new TaskManager with an empty list of tasks.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the list of tasks managed by the TaskManager.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves the list of all tasks managed by the TaskManager.
     *
     * @return The list of tasks.
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Retrieves the list of all incomplete tasks managed by the TaskManager
     *
     * @return The list of tasks whose
     */
    public List<Task> getTasks() {
        return tasks.stream().filter(task -> !task.getStatus()).collect(Collectors.toList());
    }
}

