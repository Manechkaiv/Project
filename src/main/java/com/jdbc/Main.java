package com.jdbc;

import java.util.logging.Logger;
import com.jdbc.service.impl.GuestServiceImpl;
import com.jdbc.service.impl.OrderGServiceImpl;
import com.jdbc.service.impl.PositionServiceImpl;

import java.sql.*;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/menu?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // JDBC переменные для открытия и контроля соединения
    private static Statement stmt;
    private static ResultSet rs;
    private static Connection connection;

    public static void main(String[] args) {
        GuestServiceImpl guestService = new GuestServiceImpl();
        PositionServiceImpl positionService = new PositionServiceImpl();
        OrderGServiceImpl orderGService = new OrderGServiceImpl();

        String query1 = "select pos_id, name, price from position";

        System.out.println("Connecting...");

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection successful!");
            // getting Statement object to execute query
            stmt = connection.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query1);


            while (rs.next()) {
                int pos_id = rs.getInt(1);
                String name = rs.getString(2);
                int count = rs.getInt(1);
                int price = rs.getInt(3);
                System.out.printf("pos_id: %d, name: %s, price: %s %n", pos_id, name, price);
                System.out.println("Total number of positions in the menu : " + count);
            }
            System.out.println(positionService.findAll());
            System.out.println(positionService.findEntityById(1));
            System.out.println(positionService.orderPositionByPrice());
            System.out.println(positionService.orderBackPositionByPrice());
            System.out.println(guestService.findEntityById(2));
            System.out.println(guestService.findAll());
            System.out.println("Total number of guests in the restaurant : " + guestService.getAllNumber());
            System.out.println(orderGService.findEntityById(2));
            System.out.println(orderGService.findAll());
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {/*can't do anything */}
            try {
                stmt.close();
            } catch (SQLException se) {/*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */}

        }

    }
}