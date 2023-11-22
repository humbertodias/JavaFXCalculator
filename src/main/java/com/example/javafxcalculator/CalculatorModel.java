package com.example.javafxcalculator;

import javafx.beans.property.*;

public class CalculatorModel {
    public String getNumber() {
        return number.get();
    }

    public StringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        if (number == "") {
            number = "0";
        }
        if (number.length() > 1) {
            number = number.replaceFirst("^0+(?!$)", "");
        }
        this.number.set(number);
    }

    private StringProperty number = new SimpleStringProperty("0");

    public double getArgument() {
        return argument.get();
    }

    public DoubleProperty argumentProperty() {
        return argument;
    }

    public void setArgument(double argument) {
        this.argument.set(argument);
        setNumber("0");
    }

    private DoubleProperty argument = new SimpleDoubleProperty(0);

    public Operator getOperator() {
        return operator.get();
    }

    public ObjectProperty<Operator> operatorProperty() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator.set(operator);
    }

    private ObjectProperty<Operator> operator = new SimpleObjectProperty<>(null);
}
