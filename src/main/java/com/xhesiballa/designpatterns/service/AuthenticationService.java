package com.xhesiballa.designpatterns.service;

import com.xhesiballa.designpatterns.model.DAOFactory;
import com.xhesiballa.designpatterns.model.User;
import com.xhesiballa.designpatterns.model.UserDAO;

public class AuthenticationService {
    private static final UserDAO userDAO = DAOFactory.getFactory(DAOFactory.H2).getUserDAO();

    public static User authenticateUser(User user) {
        User authenticatedUser = userDAO.getUserByUserName(user.getUserName());
        if (authenticatedUser != null && authenticatedUser.getPassword().equals(user.getPassword())) {
            return authenticatedUser;
        }
        return null;
    }
}
