package com.xhesiballa.designpatterns.view;

import com.xhesiballa.designpatterns.model.Model;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View {
    private Model model;
    private Stage primaryStage;

    public View(Model model, Stage primaryStage) {
        this.model = model;
        this.primaryStage = primaryStage;

        Button button = new Button("Say Hello World");
        StackPane root = new StackPane();
        root.getChildren().add(button);
        this.primaryStage.setScene(new Scene(root, 480, 360));
        this.primaryStage.show();

        button.setOnMouseClicked(event -> System.out.println("Hello world!"));
    }
}
