package com.xhesiballa.designpatterns.model;

/**
 * @author Xhesi Balla
 */
public class H2DAOFactory extends DAOFactory {
    public UserDAO getUserDAO() {
        return new H2UserDAO();
    }
}
