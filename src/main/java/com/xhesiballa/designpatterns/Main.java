package com.xhesiballa.designpatterns;

import com.xhesiballa.designpatterns.bootstrap.Bootstrap;
import com.xhesiballa.designpatterns.service.ViewManagerService;
import com.xhesiballa.designpatterns.view.LoginView;
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
        ViewManagerService viewManagerService = new ViewManagerService(primaryStage);

        LoginView loginView = new LoginView();

        viewManagerService.registerView(loginView);
        viewManagerService.showView(loginView.getClass());

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
