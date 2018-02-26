package de.hs_lu.mensa.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private long no;
    private String name;

    public Employee() {
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}