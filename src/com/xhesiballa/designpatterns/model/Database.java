package com.xhesiballa.designpatterns.model;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Xhesi Balla
 */
public class Database {

    private static Database instance = new Database();
    private Connection connection;
    private Server server;

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

    private Database connect() throws SQLException {
        instance.connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        server = Server.createTcpServer().start();
        return instance;
    }

    public void disconnect() throws SQLException {
        instance.connection.close();
        instance.connection = null;
        server.shutdown();
        server = null;
    }

    public Connection getConnection() throws SQLException{
        if (connection == null){
            connect();
        }
        return connection;
    }
}
