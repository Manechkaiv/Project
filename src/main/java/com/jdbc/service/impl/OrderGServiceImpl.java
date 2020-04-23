package com.jdbc.service.impl;

import com.jdbc.dao.OrderGDAOImpl;
import com.jdbc.entity.OrderG;
import com.jdbc.service.OrderGService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderGServiceImpl implements OrderGService {
    private OrderGDAOImpl orderGDAOImpl = new OrderGDAOImpl();

    @Transactional
    @Override
    public List<OrderG> findAll() {
        return orderGDAOImpl.findAll();
    }

    @Transactional
    @Override
    public void create(OrderG orderG) {
        orderGDAOImpl.create(orderG);
    }

    @Transactional
    @Override
    public void update(OrderG orderG) {
        orderGDAOImpl.update(orderG);
    }

    @Transactional
    @Override
    public void delete(OrderG orderG) {
        orderGDAOImpl.delete(orderG);
    }

    @Transactional
    @Override
    public void delete(Integer ord_id) {
        orderGDAOImpl.delete(ord_id);
    }

    @Transactional
    @Override
    public OrderG findEntityById(Integer ord_id) {
        return orderGDAOImpl.findEntityById(ord_id);
    }

}