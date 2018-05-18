package com.xhesiballa.designpatterns.model;

public abstract class DAOFactory {
    public final static int H2 = 0;
    public final static int MYSQL = 1;

    public abstract UserDAO getUserDAO();

    public static DAOFactory getFactory(int type) {
        switch (type) {
            case H2:
                return new H2DAOFactory();
            case MYSQL:
                return new MySqlDAOFactory();
            default:
                return null;
        }
    }
}
