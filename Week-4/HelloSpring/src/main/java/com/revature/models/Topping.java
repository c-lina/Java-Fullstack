package com.revature.models;

import org.springframework.stereotype.Component;

@Component //1 of the 4 stereotype annotations, which all make a Class a Bean
public class Topping {
    private int topping_id;
    private String topping_name;

    //boilerplate code---------------------

    public Topping() {
    }

    public Topping(int topping_id, String topping_name) {
        this.topping_id = topping_id;
        this.topping_name = topping_name;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public String getTopping_name() {
        return topping_name;
    }

    public void setTopping_name(String topping_name) {
        this.topping_name = topping_name;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "topping_id=" + topping_id +
                ", topping_name='" + topping_name + '\'' +
                '}';
    }
}
