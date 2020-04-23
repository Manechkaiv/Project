package com.jdbc.test.service;

import com.jdbc.entity.Guest;
import com.jdbc.service.impl.GuestServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GuestServiceTest {

    GuestServiceImpl guestService = new GuestServiceImpl();


    @Test
    public void findAll() {

        List<Guest> actual = guestService.findAll();

        Guest guest1 = new Guest(1, "Maria", "Ivanova");
        Guest guest2 = new Guest(2, "Ivan", "Brav");
        Guest guest3 = new Guest(3, "Anna", "Netrebko");

        List<Guest> expected = new ArrayList<>();
        expected.add(guest1);
        expected.add(guest2);
        expected.add(guest3);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findEntityById() {
        Guest actual = guestService.findEntityById(1);

        Guest expected = new Guest(1, "Maria", "Ivanova");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllNumber(){
        int actual = guestService.getAllNumber();

        Guest guest1 = new Guest(1, "Maria", "Ivanova");
        Guest guest2 = new Guest(2, "Ivan", "Brav");
        Guest guest3 = new Guest(3, "Anna", "Netrebko");

        int expected = 3;

        Assert.assertEquals(expected, actual);
    }
}


