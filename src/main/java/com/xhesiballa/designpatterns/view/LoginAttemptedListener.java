package com.xhesiballa.designpatterns.view;

import com.xhesiballa.designpatterns.model.User;

public interface LoginAttemptedListener {
    void login(User user);
}
