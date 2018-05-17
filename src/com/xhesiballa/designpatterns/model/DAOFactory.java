package com.xhesiballa.designpatterns.model;

/**
 * @author Xhesi Balla
 */
public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new UserDAO();
    }
}
