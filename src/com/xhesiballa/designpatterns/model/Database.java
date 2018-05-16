package com.xhesiballa.designpatterns.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Xhesi Balla
 */
public class Database {

    private static Database instance = new Database();
    private Connection connection;

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    /*
    //lazy loading version of the instance,  not thread safe
    private static instanceOld;
    public static Database getInstance(){
        if (instanceOld == null){
            instance = new Database();
        }
        return instance;
    }
    */

    public Database connect() throws SQLException {
        instance.connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        return instance;
    }

    public void disconnect() throws SQLException {
        instance.connection.close();
    }

    public Connection getConnection() {
        return connection;
    }
}
