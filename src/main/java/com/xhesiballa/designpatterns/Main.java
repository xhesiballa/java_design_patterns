package com.xhesiballa.designpatterns;

import com.xhesiballa.designpatterns.bootstrap.Bootstrap;
import com.xhesiballa.designpatterns.controller.RegisterController;
import com.xhesiballa.designpatterns.service.ViewManagerService;
import com.xhesiballa.designpatterns.view.LoginView;
import com.xhesiballa.designpatterns.view.RegisterView;
import javafx.application.Application;
import javafx.application.Platform;
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
        ViewManagerService viewManagerService = ViewManagerService.initialise(primaryStage);

        RegisterController registerController = new RegisterController();

        LoginView loginView = new LoginView();

        RegisterView registerView = new RegisterView();
        registerView.setUserCreatedListener(registerController);

        viewManagerService.registerView(loginView);
        viewManagerService.registerView(registerView);

        viewManagerService.showView(registerView.getClass());

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
