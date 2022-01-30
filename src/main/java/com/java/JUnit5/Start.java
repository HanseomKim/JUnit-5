package com.java.JUnit5;

public class Start {
    private Status status = Status.ENDED;

    private int limit;

    public Start(int limit) {
        if(limit < 0) throw new IllegalArgumentException("limit은 0보다 커야합니다.");
        this.limit = limit;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getLimit() {
        return this.limit;
    }
}
