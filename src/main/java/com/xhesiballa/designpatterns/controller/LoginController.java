package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.service.AuthenticationService;
import com.xhesiballa.designpatterns.service.ViewManagerService;
import com.xhesiballa.designpatterns.view.ChangeViewListener;
import com.xhesiballa.designpatterns.view.LoginAttemptedListener;
import com.xhesiballa.designpatterns.view.LoginView;
import com.xhesiballa.designpatterns.view.RegisterView;

/**
 * @author Xhesi Balla
 */
public class LoginController implements LoginAttemptedListener, ChangeViewListener {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(User user) {

        User authenticatedUser = AuthenticationService.authenticateUser(user);
        if(authenticatedUser!= null){
            //ViewManagerService.get().showView();
            loginView.hideErrorMessage();
        }else{
            loginView.showErrorMessage("Username or password did not match!");
        }
    }

    @Override
    public void changeView() {
        ViewManagerService.get().showView(RegisterView.class);
    }
}
