package com.connectmymatch.j4zib.connectmymatch;

public class Subject {
    private int id;
    private String name;
    private int image;
    private double progress;


    public Subject(String name, double progress, int image) {
        this.name = name;
        this.progress = progress;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
