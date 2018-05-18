package com.xhesiballa.designpatterns.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xhesi Balla
 * <p>
 * One DAO class per table or view
 * CRUD -create, retrieve, update, delete
 */
public class H2UserDAO implements UserDAO {

    @Override
    public User createUser(User user) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String query = "INSERT INTO USERS(username, password, email) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            User newUser = user.clone();
            if(resultSet.next())
            {
                int id = resultSet.getInt(1);
                newUser.setId(id);
            }
            return newUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String query = "SELECT * FROM USERS WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetTOUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String query = "SELECT * FROM USERS";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = resultSetTOUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public int updateUser(User user) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String query = "UPDATE USERS SET username = ?, email = ?, password = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteUser(User user) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String query = "DELETE USERS  WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, user.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void deleteUsers(){
        Connection connection;
        try {
            connection = Database.getInstance().getConnection();
            String query = "DELETE USERS";
            PreparedStatement statement = connection.prepareStatement(query);
             statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String query = "SELECT * FROM USERS WHERE username= ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetTOUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User resultSetTOUser(ResultSet resultSet) {
        User user = null;
        try {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
