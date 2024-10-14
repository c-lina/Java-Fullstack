package com.revature.models;

public class Duelist {
    private int duelist_id;
    private String first_name;
    private String last_name;

    public Duelist() {
    }

    public Duelist(int duelist_id, String first_name, String last_name) {
        this.duelist_id = duelist_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Duelist(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getDuelist_id() {
        return duelist_id;
    }

    public void setDuelist_id(int duelist_id) {
        this.duelist_id = duelist_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Duelist{" +
                "duelist_id=" + duelist_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
