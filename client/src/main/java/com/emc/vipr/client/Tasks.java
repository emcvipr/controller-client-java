package com.emc.vipr.client;

import com.emc.storageos.model.TaskResourceRep;
import com.emc.vipr.client.exceptions.ViPRException;
import com.emc.vipr.client.impl.RestClient;
import com.emc.vipr.client.core.impl.TaskUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representation of multiple asynchronous tasks returned from an operation.
 *
 * @param <R> Type of the underlying resource running the operation.
 */
public class Tasks<R> {
    private List<Task<R>> tasks;

    public Tasks(RestClient client, List<TaskResourceRep> tasks, Class<R> resourceClass) {
        this.tasks = new ArrayList<Task<R>>();
        if (tasks != null) {
            for (TaskResourceRep task : tasks) {
                this.tasks.add(new Task<R>(client, task, resourceClass));
            }
        }
    }

    /**
     * Retrieves all tasks associated with the operation.
     *
     * @return List of tasks.
     */
    public List<Task<R>> getTasks() {
        return tasks;
    }

    /**
     * Retrieves the first task in the list.
     *
     * @return The first task or null if there are no tasks in the list.
     */
    public Task<R> firstTask() {
        if (tasks.size() > 0) {
            return tasks.get(0);
        }
        return null;
    }
    
    /**
     * Retrieves the latest task in the list that has finished processing.
     *
     * @return The latest task or null if there are no tasks in the list.
     */
    public Task<R> latestFinishedTask() {
        if (tasks.size() > 0) {
            Collections.sort(tasks, new LatestFinishedTaskComparator());
            Task<R> latestTask = tasks.get(0);
            if(latestTask.getEndTime() != null) {
                return latestTask;
            }
        }
        return null;
    }

    /**
     * Waits for tasks to complete (go into a pending or error state). If an error occurs
     * it will be thrown as an exception.
     *
     * @throws ViPRException Thrown if any task is in an error state.
     * @return This tasks.
     */
    public Tasks<R> waitFor() throws ViPRException {
        return waitFor(-1);
    }

    /**
     * Waits for tasks to complete (go into a pending or error state). If an error occurs
     * it will be thrown as an exception.
     *
     * @param timeoutMillis Timeout after a number of milliseconds
     * @throws com.emc.vipr.client.exceptions.TimeoutException Thrown if a timeout occurs.
     * @throws ViPRException Thrown if any task is in an error state.
     * @return This tasks.
     */
    public Tasks<R> waitFor(long timeoutMillis) throws ViPRException {
        List<TaskResourceRep> taskImpls = new ArrayList<TaskResourceRep>();
        for (Task<R> task : tasks) {
            task.doTaskWait(timeoutMillis);
            taskImpls.add(task.getTaskResource());
        }
        TaskUtil.checkForErrors(taskImpls);
        return this;
    }

    /**
     * Waits for tasks to complete (go into a pending or error state). If an error occurs
     * it will be thrown as an exception. If any task was successful this returns the
     * actual object for the underlying resource.
     *
     * @throws com.emc.vipr.client.exceptions.TimeoutException Thrown if a timeout occurs.
     * @throws ViPRException Thrown if any task is in an error state.
     * @return List of resource objects.
     */
    public List<R> get() {
        waitFor();
        return doGetResources();
    }

    /**
     * Waits for tasks to complete (go into a pending or error state). If an error occurs
     * it will be thrown as an exception. If any task was successful this returns the
     * actual object for the underlying resource.
     *
     * @param timeoutMillis Timeout after a number of milliseconds
     * @throws com.emc.vipr.client.exceptions.TimeoutException Thrown if a timeout occurs.
     * @throws ViPRException Thrown if any task is in an error state.
     * @return List of resource objects.
     */
    public List<R> get(long timeoutMillis) {
        waitFor(timeoutMillis);
        return doGetResources();
    }

    private List<R> doGetResources() {
        List<R> resources = new ArrayList<R>();
        for (Task<R> task: tasks) {
            resources.add(task.doGetResource());
        }
        return resources;
    }
    
    protected static class LatestFinishedTaskComparator implements Comparator<Task> {
        public int compare(Task task1, Task task2) {
            if (task1.getEndTime() == null && task2.getEndTime() == null) {
                return 0;
            }
            else if (task1.getEndTime() == null) {
                return 1;
            }
            else if (task2.getEndTime() == null) {
                return -1;
            }
            else {
                return task2.getEndTime().compareTo(task1.getEndTime());
            }
        }
    }
}
