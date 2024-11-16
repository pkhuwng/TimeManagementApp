package com.example.myapplication.models;

import java.util.List;

public class Note {
    private int noteID;
    private int userID;
    private String title;
    private String content;
    private List<String> label;
    private long createdTime;
    private long editedTime;

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(long editedTime) {
        this.editedTime = editedTime;
    }
}
