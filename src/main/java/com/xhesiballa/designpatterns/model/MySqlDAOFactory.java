package com.xhesiballa.designpatterns.model;

public class MySqlDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }
}
