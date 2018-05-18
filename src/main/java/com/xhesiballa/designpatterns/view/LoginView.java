package com.xhesiballa.designpatterns.view;

import com.xhesiballa.designpatterns.config.Config;
import com.xhesiballa.designpatterns.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Xhesi Balla
 */
public class LoginView implements View {
    private final Scene scene;
    private final TextField userTextField;
    private final PasswordField pwBox;
    private LoginAttemptedListener loginAttemptedListener;
    private ChangeViewListener changeViewListener;

    public LoginView() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Login");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button registerButton = new Button("Register");
        HBox hbBtnRegister = new HBox(10);
        hbBtnRegister.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnRegister.getChildren().add(registerButton);
        grid.add(hbBtnRegister, 0, 3);
        registerButton.setOnMouseClicked(event -> fireChangeViewEvent());

        Button loginButton = new Button("Login");
        HBox hbBtnLogin = new HBox(10);
        hbBtnLogin.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnLogin.getChildren().add(loginButton);
        grid.add(hbBtnLogin, 1, 3);
        loginButton.setOnMouseClicked(event -> fireLoginAttemptedEvent());

        scene = new Scene(grid, Config.windowWidth, Config.windowHeight);
    }

    public void setLoginAttemptedListener(LoginAttemptedListener loginAttemptedListener) {
        this.loginAttemptedListener = loginAttemptedListener;
    }

    public void setChangeViewListener(ChangeViewListener changeViewListener) {
        this.changeViewListener = changeViewListener;
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    private void fireChangeViewEvent() {
        if (changeViewListener != null) {
            changeViewListener.changeView();
        }
    }

    private void fireLoginAttemptedEvent() {
        if (loginAttemptedListener != null) {
            User user = new User();
            user.setUserName(userTextField.getText());
            user.setPassword(pwBox.getText());
            loginAttemptedListener.login(user);
        }
    }
}
