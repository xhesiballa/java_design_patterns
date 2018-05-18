package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.service.AuthenticationService;
import com.xhesiballa.designpatterns.view.LoginAttemptedListener;

/**
 * @author Xhesi Balla
 */
public class LoginController implements LoginAttemptedListener {

    @Override
    public void login(User user) {
        User authenticatedUser = AuthenticationService.authenticateUser(user);
    }
}
