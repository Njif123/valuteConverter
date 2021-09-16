package com.example.valuteconverter;

public class ValuteModel {
    private String charCode;
    private int nominal;
    private double value;
    private double previousValue;

    public ValuteModel(String charCode, int nominal, double value, double previousValue) {
        this.charCode = charCode;
        this.nominal = nominal;
        this.value = value;
        this.previousValue = previousValue;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }


    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(double previousValue) {
        this.previousValue = previousValue;
    }
}
