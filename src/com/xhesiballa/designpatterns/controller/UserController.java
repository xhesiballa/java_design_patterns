package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.DAOFactory;
import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.model.UserDAO;
import com.xhesiballa.designpatterns.view.RegisterView;
import com.xhesiballa.designpatterns.view.UserCreatedListener;

/**
 * @author Xhesi Balla
 */
public class UserController implements UserCreatedListener {
    private RegisterView registerView;
    private UserDAO userDAO = DAOFactory.getUserDAO();

    @Override
    public void onUserCreated(User user) {
        System.out.println("Registered user:");
        userDAO.createUser(user);
        System.out.println(user);
    }
}
