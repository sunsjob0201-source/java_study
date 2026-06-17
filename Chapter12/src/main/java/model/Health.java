package model;

import java.io.Serializable;

public class Health implements Serializable {

    private double height;
    private double weight;
    private double bmi;
    private String bodyType;

    public Health() {
    }

    public Health(double height,
                  double weight,
                  double bmi,
                  String bodyType) {

        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bodyType = bodyType;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }

    public String getBodyType() {
        return bodyType;
    }
}