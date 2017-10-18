package com.grupodois.conversaoapp;

import android.app.Application;

public class CurrencyRates extends Application{
    private Double USD, EUR, GBP, JPY, BRL;
    private String base;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getEUR() {
        return EUR;
    }

    public void setEUR(Double EUR) {
        this.EUR = EUR;
    }

    public Double getGBP() {
        return GBP;
    }

    public void setGBP(Double GBP) {
        this.GBP = GBP;
    }

    public Double getJPY() {
        return JPY;
    }

    public void setJPY(Double JPY) {
        this.JPY = JPY;
    }

    public Double getBRL() {
        return BRL;
    }

    public void setBRL(Double BRL) {
        this.BRL = BRL;
    }
}
