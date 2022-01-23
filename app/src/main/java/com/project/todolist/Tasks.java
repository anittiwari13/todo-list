package com.project.todolist;

public class Tasks {
    public Tasks(int sno, String task) {
        this.sno = sno;
        this.task = task;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    private int sno;
    private String task;
}
