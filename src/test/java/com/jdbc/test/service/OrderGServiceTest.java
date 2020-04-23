package com.jdbc.test.service;

import com.jdbc.entity.Guest;
import com.jdbc.entity.OrderG;
import com.jdbc.entity.Position;
import com.jdbc.service.impl.OrderGServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class OrderGServiceTest {

    OrderGServiceImpl orderGService = new OrderGServiceImpl();
    OrderG orderG = new OrderG();

    @Test
    public void findAll() {

        List<OrderG> actual = orderGService.findAll();

        Guest guest1 = new Guest(1, "Maria", "Ivanova");
        Guest guest2 = new Guest(2, "Ivan", "Brav");
        Guest guest3 = new Guest(3, "Anna", "Netrebko");

        List<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        guests.add(guest3);

        Position position1 = new Position(1, "Meat", 350);
        Position position2 = new Position(2, "Fish", 450);
        Position position3 = new Position(3, "Chicken", 250);
        Position position4 = new Position(4, "Cake", 300);

        List<Position> positions = new ArrayList<>();
        positions.add(position1);
        positions.add(position2);
        positions.add(position3);
        positions.add(position4);

        OrderG orderG1 = new OrderG(1, guests.get(3), positions.get(3));
        OrderG orderG2 = new OrderG(2, guests.get(1), positions.get(4));
        OrderG orderG3 = new OrderG(3, guests.get(2), positions.get(2));

        List<OrderG> expected = new ArrayList<>();
        expected.add(orderG1);
        expected.add(orderG2);
        expected.add(orderG3);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findEntityById() {

        OrderG actual = orderGService.findEntityById(1);

        Position position3 = new Position(3, "Chicken", 250);
        Guest guest3 = new Guest(3, "Anna", "Netrebko");

        OrderG expected = new OrderG(1, guest3, position3);

        Assert.assertEquals(expected, actual);
    }

}

