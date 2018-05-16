package com.xhesiballa.designpatterns.view;

import com.xhesiballa.designpatterns.model.User;

/**
 * @author Xhesi Balla
 */
public interface UserCreatedListener {
    void onUserCreated(User user);
}
