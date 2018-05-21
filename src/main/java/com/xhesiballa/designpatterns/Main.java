package com.xhesiballa.designpatterns;

import com.xhesiballa.designpatterns.bootstrap.Bootstrap;
import com.xhesiballa.designpatterns.controller.LoginController;
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


        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        loginView.setChangeViewListener(loginController)
                .setLoginAttemptedListener(loginController);
        viewManagerService.registerView(loginView);


        RegisterController registerController = new RegisterController();
        RegisterView registerView = new RegisterView();
        registerView.setUserCreatedListener(registerController);
        viewManagerService.registerView(registerView);


        viewManagerService.showView(registerView.getClass());

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
