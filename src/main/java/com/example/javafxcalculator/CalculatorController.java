package com.example.javafxcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label numberLabel;

    @FXML
    private Button clearButton;
    @FXML
    private Button deleteButton;

    @FXML
    private Button divideButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button addButton;
    @FXML
    private Button equalsButton;

    @FXML
    private Button signButton;
    @FXML
    private Button decimalPointButton;

    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;

    private CalculatorModel model;

    public void initModel(CalculatorModel model) {
        this.model = model;

        model.numberProperty().addListener((obs, old, newVal) -> {
            numberLabel.setText(newVal);
        });
    }

    @FXML
    private void clearButtonClicked() {
        model.setNumber("");
        model.setArgument(0);
    }

    @FXML
    private void deleteButtonClicked() {
        String num = model.getNumber();
        if (num != "") {
            model.setNumber(num.substring(0, num.length() - 1));
        }
    }

    private void doCalculation() {
        double arg1 = model.getArgument();

        double arg2 = Double.parseDouble(model.getNumber());
        double result = 0;

        switch (model.getOperator()) {
            case Add -> {
                result = arg1 + arg2;
            }
            case Subtract -> {
                result = arg1 - arg2;
            }
            case Multiply -> {
                result = arg1 * arg2;
            }
            case Divide -> {
                result = arg1 / arg2;
            }
        }
        model.setArgument(0);
        model.setNumber(Double.toString(result));
        model.setOperator(null);
    }

    private void operatorButtonClicked(Operator op) {
        model.setArgument(Double.parseDouble(model.getNumber()));
        if (model.getOperator() != null) {
            doCalculation();
        }
        model.setNumber("0");
        model.setOperator(op);
    }

    @FXML
    private void divideButtonClicked() {
        operatorButtonClicked(Operator.Divide);
    }

    @FXML
    private void multiplyButtonClicked() {
        operatorButtonClicked(Operator.Multiply);
    }

    @FXML
    private void subtractButtonClicked() {
        operatorButtonClicked(Operator.Subtract);
    }

    @FXML
    private void addButtonClicked() {
        operatorButtonClicked(Operator.Add);
    }

    @FXML
    private void equalsButtonClicked() {
        doCalculation();
    }

    @FXML
    private void signButtonClicked() {
        String num = model.getNumber();
        if (num.charAt(0) == '-') {
            num = num.substring(1);
        } else {
            num = '-' + num;
        }
        model.setNumber(num);
    }

    @FXML
    private void decimalPointButtonClicked() {
        if (!model.getNumber().contains(".")) {
            model.setNumber(model.getNumber() + '.');
        }
    }

    private void numberButtonClicked(int n) {
        model.setNumber(model.getNumber() + n);
    }

    @FXML
    private void zeroButtonClicked() {
        numberButtonClicked(0);
    }

    @FXML
    private void oneButtonClicked() {
        numberButtonClicked(1);
    }

    @FXML
    private void twoButtonClicked() {
        numberButtonClicked(2);
    }

    @FXML
    private void threeButtonClicked() {
        numberButtonClicked(3);
    }

    @FXML
    private void fourButtonClicked() {
        numberButtonClicked(4);
    }

    @FXML
    private void fiveButtonClicked() {
        numberButtonClicked(5);
    }

    @FXML
    private void sixButtonClicked() {
        numberButtonClicked(6);
    }

    @FXML
    private void sevenButtonClicked() {
        numberButtonClicked(7);
    }

    @FXML
    private void eightButtonClicked() {
        numberButtonClicked(8);
    }

    @FXML
    private void nineButtonClicked() {
        numberButtonClicked(9);
    }
}
