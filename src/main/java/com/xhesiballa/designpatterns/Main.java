package com.xhesiballa.designpatterns;

import com.xhesiballa.designpatterns.bootstrap.Bootstrap;
import com.xhesiballa.designpatterns.controller.Controller;
import com.xhesiballa.designpatterns.controller.UserController;
import com.xhesiballa.designpatterns.model.Model;
import com.xhesiballa.designpatterns.view.RegisterView;
import com.xhesiballa.designpatterns.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Xhesi Balla
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Bootstrap.performBootstrapping();
        Model model = new Model();

        View view = new View(model, primaryStage);
        RegisterView registerView = new RegisterView(model, primaryStage);

        Controller controller = new Controller(model, view);
        UserController userController = new UserController();

        view.setHelloWorldListener(controller);
        registerView.setUserCreatedListener(userController);
    }
}
