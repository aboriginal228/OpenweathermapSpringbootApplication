package com.testweatherboot2.entity.weather_ent;

public class Hourly {
    private double pop;
    private int intPop;

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public void setIntPop() {
        intPop = (int) (pop * 100);
    }

    public int getIntPop() {
        return intPop;
    }
}
