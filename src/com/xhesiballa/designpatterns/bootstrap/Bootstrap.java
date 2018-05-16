package com.xhesiballa.designpatterns.bootstrap;

import com.xhesiballa.designpatterns.model.Database;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Xhesi Balla
 */
public class Bootstrap {

    public static void performBootstrapping() {
        try {
            Statement statement = Database.getInstance().connect().getConnection().createStatement();
            createDatabaseSchema(statement);
            insertUsers(statement);
            Database.getInstance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabaseSchema(Statement statement) {
        String query = "CREATE TABLE USERS " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " username VARCHAR(255), " +
                " password VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertUsers(Statement statement) {
        String query = "INSERT INTO USERS(username, password) VALUES('admin', '12345')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
