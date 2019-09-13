package com.hillel.web.homeLibrary.staff;

public class Personnel {

    private int id;
    private String name;
    private String date;

    public Personnel(int id,String name,String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Personnel(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
