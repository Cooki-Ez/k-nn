package com.company;

import java.util.List;

public class Iris {
    private String name;
    List<Double> ys;
    double dist;
    public String getName() {
        return name;
    }

    public Iris(String name, List<Double> ys) {
        this.name = name;
        this.ys = ys;
    }
    public Iris(double dist){
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Iris{" +
                ", ys=" + ys +
                '}';
    }
}
