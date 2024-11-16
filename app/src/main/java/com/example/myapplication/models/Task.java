package com.example.myapplication.models;
import com.example.myapplication.enums.TaskStatus;
import com.example.myapplication.enums.RecurrenceInterval;

import java.util.List;

public class Task {
    private int taskID;
    private int userID;
    private String title;
    private String description;
    private List<String> label;
    private long startTime;
    private long endTime;
    private boolean isRecurring;
    private RecurrenceInterval recurrenceInterval;
    private TaskStatus status;


    public int getTaskID() {return taskID;}
    public void setTaskID(int taskID) {this.taskID = taskID;}
    public int getUserID() {return userID;}
    public void setUserID(int userID) {this.userID = userID;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public List<String> getLabel() {return label;}
    public void setLabel(List<String> label) {this.label = label;}
    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public boolean isRecurring() {
        return isRecurring;
    }
    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }
    public RecurrenceInterval getRecurrenceInterval() {
        return recurrenceInterval;
    }
    public void setRecurrenceInterval(RecurrenceInterval recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
