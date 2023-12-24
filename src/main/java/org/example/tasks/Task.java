package org.example.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
/**
 * Represents a task with content, timestamp, and completion status.
 */
public class Task implements Serializable {
    /**
     * The content of the task.
     */
    private final String content;

    /**
     * The timestamp indicating when the task was created.
     */
    private final LocalDateTime timestamp;

    /**
     * The completion status of the task (false if not completed, true if completed).
     */
    private boolean completed;

    /**
     * Creates an instance of Task.
     *
     * Creates a Task with the current localized timestamp and user-provided content.
     *
     * @param content The content of the task.
     */
    public Task(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();

    }

    /**
     * Retrieves the content of the task.
     *
     * @return The content of the task.
     */
    public String readContent() {
        return this.content;
    }

    /**
     * Marks the task as complete.
     *
     * If the task was already marked as complete, this method returns 0.
     * If the task was not previously marked as complete and is now marked as complete, it returns 1.
     *
     * @return 0 if the task was already complete, 1 if the task is now marked as complete.
     */
    public int setComplete() {
        if (this.completed) {
            return 0;
        } else {
            this.completed = true;
            return 1;
        }
    }

    /**
     * Retrieves the completion status of the task.
     *
     * @return false if the task is not completed, true if the task is completed.
     */
    public boolean getStatus() {
        return this.completed;
    }

    /**
     * Retrieves the timestamp of when the task was created.
     *
     * @return The timestamp indicating when the task was created.
     */
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Returns a string representation of the task, including its timestamp and content.
     *
     * The timestamp is formatted using the pattern "yyyy-MM-dd HH:mm:ss".
     *
     * @return A string representation of the task in the format "[timestamp] content".
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + timestamp.format(formatter) + "] " + content;
    }
}
