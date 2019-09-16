package com.hillel.web.homeLibrary.staff;

public class Personnel extends Id {

    private String name;
    private String date;

    public Personnel(int id,String name,String date) {
        super(id);
        this.name = name;
        this.date = date;
    }

    public Personnel(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
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
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
