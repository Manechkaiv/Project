package com.jdbc.dao;

import com.jdbc.entity.Position;
import org.springframework.stereotype.Repository;
import com.jdbc.entity.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class GuestDAOImpl extends AbstractDAO<Integer, Guest> {

    private static final  String URL = "jdbc:mysql://localhost:3306/menu?serverTimezone=Europe/Minsk&useSSL=false";
    private static final  String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Statement stmt;
    private static ResultSet rs;

    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM guests";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM guests WHERE id=?";

    @Override
    public List<Guest> findAll() {
        List<Guest> guests = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int gst_id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                guests.add(new Guest(gst_id, firstName, lastName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return guests;
    }

    public int getAllNumber() {
        int number = 0;
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT count(*) FROM guests");
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return number;
    }


    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Guest guest) {
        throw new UnsupportedOperationException();
    }

    public boolean create(Guest guest) {
        throw new UnsupportedOperationException();
    }

    public Guest update(Guest guest) {
        throw new UnsupportedOperationException();
    }


    public Guest findEntityById(Integer gst_id) {
        Guest guest = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM guests WHERE gst_id=?")) {
            statement.setInt(1, gst_id);
            rs = statement.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                guest = new Guest(gst_id, firstName, lastName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return guest;
    }

}

