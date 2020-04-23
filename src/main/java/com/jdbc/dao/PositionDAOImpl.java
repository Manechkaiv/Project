package com.jdbc.dao;

import org.springframework.stereotype.Repository;
import com.jdbc.entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PositionDAOImpl extends AbstractDAO<Integer, Position> {
    private static final  String URL = "jdbc:mysql://localhost:3306/menu?serverTimezone=Europe/Minsk&useSSL=false";
    private static final  String USERNAME = "root";
    private static final String PASSWORD = "root";

    // JDBC переменные для открытия и контроля соединения
    private static Statement stmt;
    private static ResultSet rs;


    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM position";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM position WHERE pos_id=?";


    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int pos_id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                positions.add(new Position(pos_id, name, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return positions;
    }

    public Position findEntityById(Integer pos_id) {
        Position position = null;
        try ( Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, pos_id);
            rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int price = rs.getInt(3);
                position = new Position(pos_id, name, price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return position;
    }



    public List<Position> orderPositionByPrice() {
        List<Position> positionsOrder = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM position ORDER BY price");
            while (rs.next()) {
                int pos_id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                positionsOrder.add(new Position(pos_id, name, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return positionsOrder;
    }

    public List<Position> orderBackPositionByPrice() {
        List<Position> positionsOrderBack = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM position ORDER BY price DESC");
            while (rs.next()) {
                int pos_id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                positionsOrderBack.add(new Position(pos_id, name, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return positionsOrderBack;
    }


    @Override
    public boolean delete(Integer pos_id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Position position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Position position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Position update(Position position) {
        throw new UnsupportedOperationException();
    }
}

