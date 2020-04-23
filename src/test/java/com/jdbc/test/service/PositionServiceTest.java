package com.jdbc.test.service;

import com.jdbc.entity.Position;
import com.jdbc.service.impl.PositionServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PositionServiceTest {

    PositionServiceImpl positionService = new PositionServiceImpl();

        @Test
        public void findAll() {

            List<Position> actual = positionService.findAll();

            Position position1 = new Position(1, "Meat", 350);
            Position position2 = new Position(2, "Fish", 450);
            Position position3 = new Position(3, "Chicken", 250);
            Position position4 = new Position(4, "Cake", 300);

            List<Position> expected = new ArrayList<>();
            expected.add(position1);
            expected.add(position2);
            expected.add(position3);
            expected.add(position4);

            Assert.assertEquals(expected, actual);

        }

        @Test
        public void findEntityById() {
            Position actual = positionService.findEntityById(1);

            Position expected = new Position(1, "Meat", 350);

           Assert.assertEquals(expected, actual);
        }

        @Test
        public void orderPositionByPrice() {

            List<Position> actual = positionService.orderPositionByPrice();

            Position position1 = new Position(1, "Meat", 350);
            Position position2 = new Position(2, "Fish", 450);
            Position position3 = new Position(3, "Chicken", 250);
            Position position4 = new Position(4, "Cake", 300);

            List<Position> expected = new ArrayList<>();
            expected.add(position3);
            expected.add(position4);
            expected.add(position1);
            expected.add(position2);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void orderBackPositionByPrice() {

            List<Position> actual = positionService.orderBackPositionByPrice();

            Position position1 = new Position(1, "Meat", 350);
            Position position2 = new Position(2, "Fish", 450);
            Position position3 = new Position(3, "Chicken", 250);
            Position position4 = new Position(4, "Cake", 300);

            List<Position> expected = new ArrayList<>();
            expected.add(position2);
            expected.add(position1);
            expected.add(position4);
            expected.add(position3);

            Assert.assertEquals(expected, actual);
        }
    }

