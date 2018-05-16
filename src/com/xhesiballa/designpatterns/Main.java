package com.xhesiballa.designpatterns;

import com.xhesiballa.designpatterns.controller.Controller;
import com.xhesiballa.designpatterns.model.Model;
import com.xhesiballa.designpatterns.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        View view = new View(model, primaryStage);
        Controller controller = new Controller(model, view);
    }
}
