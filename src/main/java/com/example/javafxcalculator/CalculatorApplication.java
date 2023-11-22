package com.example.javafxcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 300, 450);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = fxmlLoader.getController();
        controller.initModel(model);
    }

    public static void main(String[] args) {
        launch();
    }
}