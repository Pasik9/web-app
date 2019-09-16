package com.hillel.web.homeLibrary.staff;

public abstract class Id {

    private int id;

    public Id(int id) {
        this.id = id;
    }

    public Id() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
