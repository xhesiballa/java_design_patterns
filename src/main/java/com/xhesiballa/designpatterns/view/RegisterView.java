package com.xhesiballa.designpatterns.view;

import com.xhesiballa.designpatterns.config.Config;
import com.xhesiballa.designpatterns.model.Model;
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
import javafx.stage.Stage;

/**
 * @author Xhesi Balla
 */
public class RegisterView implements View {
    private final Scene scene;
    private UserCreatedListener userCreatedListener;

    private TextField userTextField;
    private TextField emailTextField;
    private PasswordField pwBox;

    public RegisterView(Model mode, Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Register");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label email = new Label("E-mail:");
        grid.add(email, 0, 2);

        emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 3);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);

        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        btn.setOnMouseClicked(event -> fireUserCreatedEvent());
        Scene scene = new Scene(grid, Config.windowWidth, Config.windowHeight);
        this.scene = scene;
    }

    public void setUserCreatedListener(UserCreatedListener userCreatedListener) {
        this.userCreatedListener = userCreatedListener;
    }

    private void fireUserCreatedEvent() {
        if (userCreatedListener != null) {
            User user = new User();
            user.setUserName(userTextField.getText());
            user.setEmail(emailTextField.getText());
            user.setPassword(pwBox.getText());
            userCreatedListener.onUserCreated(user);
        }
    }

    @Override
    public Scene getScene() {
        return scene;
    }
}
