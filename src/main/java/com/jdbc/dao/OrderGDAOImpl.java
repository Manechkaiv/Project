package com.jdbc.dao;

import com.jdbc.entity.Position;
import com.jdbc.entity.Guest;
import com.jdbc.entity.OrderG;
import com.jdbc.service.impl.GuestServiceImpl;
import com.jdbc.service.impl.PositionServiceImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class OrderGDAOImpl extends OrderGDAO<Integer, OrderG> {
    GuestServiceImpl guestService = new GuestServiceImpl();
    PositionServiceImpl positionService = new PositionServiceImpl();

    private static final  String URL = "jdbc:mysql://localhost:3306/menu?serverTimezone=Europe/Minsk&useSSL=false";
    private static final  String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Statement stmt;
    private static ResultSet rs;

    public OrderG findEntityById(Integer ord_id) {
        OrderG orderG = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM orderofguest WHERE ord_id=?")) {
            statement.setInt(1, ord_id);
            rs = statement.executeQuery();
            if (rs.next()) {
                Guest guest = guestService.findEntityById(rs.getInt(2));
                Position position = positionService.findEntityById(rs.getInt(3));
                orderG = new OrderG(ord_id, guest, position);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderG;
    }

     @Override
    public List<OrderG> findAll() {
        List<OrderG> ordersG = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM orderofguest");
            while (rs.next()) {
                int ord_id = rs.getInt(1);
                Guest guest = guestService.findEntityById(rs.getInt(2));
                Position position = positionService.findEntityById(rs.getInt(3));
                ordersG.add(new OrderG(ord_id, guest, position));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordersG;
    }


    public boolean delete(Integer gst_id) {
        throw new UnsupportedOperationException();
    }

    public boolean delete(OrderG orderG) {
        throw new UnsupportedOperationException();
    }

    public boolean create(OrderG orderG) {
        throw new UnsupportedOperationException();
    }

    public OrderG update(OrderG orderG) {
        throw new UnsupportedOperationException();
    }

}


