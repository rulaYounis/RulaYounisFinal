package com.example.user.rulayounis;

import java.io.Serializable;

public class Alarm implements Serializable {
    private String image;
    private String name;
    private String time;
    private String date;
    private String task;
    private String key;

    public Alarm(String image, String name, String time, String date, String task) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.date = date;
        this.task = task;
    }

    public Alarm(String image, String name, String time, String date, String task, String key) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.date = date;
        this.task = task;
        this.key = key;
    }
    public Alarm(int image, String name, String time, String date, String task) {
        this.image = "";
        this.name = name;
        this.time = time;
        this.date = date;
        this.task = task;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getKey() {
        return key;
    }
}
