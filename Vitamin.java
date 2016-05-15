package com.benlewis.vitamintrackerapp;

/**
 * Created by benlewis on 13/05/16.
 */
public class Vitamin {

    String name;
    String dose;
    String doseMetric;
    String day;
    String time;

    public String printVitamin() {
        return this.getName()+ "\n" + "Dose: " + this.getDose() + " " + this.getDoseAmount() +
                "\n" + this.getDay() + " " + this.getTime();
    }

    public Vitamin(String name, String dose, String doseMetric, String day, String time) {
        this.name = name;
        this.dose = dose;
        this.doseMetric = doseMetric;
        this.day = day;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDoseAmount() {
        return doseMetric;
    }

    public void setDoseAmount(String doseAmount) {
        this.doseMetric = doseAmount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
