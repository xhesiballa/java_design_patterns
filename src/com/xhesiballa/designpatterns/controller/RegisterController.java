package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.view.UserCreatedListener;

/**
 * @author Xhesi Balla
 */
public class RegisterController implements UserCreatedListener {

    @Override
    public void onUserCreated(User user) {
        System.out.println("Registered user:");
        System.out.println(user);
    }
}
