package com.xhesiballa.designpatterns.model;

import com.xhesiballa.designpatterns.bootstrap.Bootstrap;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Xhesi Balla
 */
public class UserDAOTest {
    private static UserDAO userDAO = DAOFactory.getUserDAO();

    @BeforeClass
    public static void createSchema() {
        Bootstrap.performBootstrapping();
    }

    @Before
    public void setUp() {
        userDAO.deleteUsers();
    }

    @Test
    public void createUser() throws Exception {
        User user = new User();
        User newUser = userDAO.createUser(user);
        assertNotNull(newUser);
        assertNotEquals(0, newUser.getId());
    }

    @Test
    public void getUser() throws Exception {
        User user = new User();
        User newUser = userDAO.createUser(user);
        User retrievedUser = userDAO.getUser(newUser.getId());
        assertNotNull(retrievedUser);
    }

    @Test
    public void getUsers() throws Exception {
        userDAO.createUser(new User());
        userDAO.createUser(new User());

        List<User> users = userDAO.getUsers();

        assert (users.size() >= 2);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setUserName("foo");

        User newUser = userDAO.createUser(user);
        newUser.setUserName("new_foo");

        userDAO.updateUser(newUser);

        User updatedUser = userDAO.getUser(newUser.getId());

        assertEquals("new_foo", updatedUser.getUserName());
    }

    @Test
    public void deleteUser() throws Exception {
        User newUser = userDAO.createUser(new User());
        userDAO.deleteUser(newUser);

        User deletedUser = userDAO.getUser(newUser.getId());

        assertNull(deletedUser);
    }

    @Test
    public void deleteUsers() throws Exception {
        userDAO.createUser(new User());
        userDAO.createUser(new User());

        List<User> users = userDAO.getUsers();

        assertEquals(users.size(), 2);

        userDAO.deleteUsers();

        users = userDAO.getUsers();

        assertEquals(users.size(), 0);
    }

    @AfterClass
    public static void disconnect() {
        try {
            Database.getInstance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}