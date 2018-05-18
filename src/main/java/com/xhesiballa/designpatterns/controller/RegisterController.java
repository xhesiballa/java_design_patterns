package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.DAOFactory;
import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.model.UserDAO;
import com.xhesiballa.designpatterns.service.ViewManagerService;
import com.xhesiballa.designpatterns.view.LoginView;
import com.xhesiballa.designpatterns.view.RegisterView;
import com.xhesiballa.designpatterns.view.UserCreatedListener;

/**
 * @author Xhesi Balla
 */
public class RegisterController implements UserCreatedListener {
    private UserDAO userDAO = DAOFactory.getFactory(DAOFactory.H2).getUserDAO();
    private ViewManagerService viewManagerService = ViewManagerService.get();

    @Override
    public void onUserCreated(User user) {
        userDAO.createUser(user);
        viewManagerService.showView(LoginView.class);
    }
}
