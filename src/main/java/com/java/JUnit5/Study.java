package com.java.JUnit5;

public class Study {
    private int index;
    private String title;

    public Study(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Study{" +
                "index=" + index +
                ", title='" + title + '\'' +
                '}';
    }
}
