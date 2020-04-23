package com.jdbc.service.impl;

import com.jdbc.dao.AbstractDAO;
import com.jdbc.dao.PositionDAOImpl;
import com.jdbc.entity.Position;
import com.jdbc.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionDAOImpl positionDAOImpl = new PositionDAOImpl();

    @Transactional
    @Override
    public List<Position> findAll() {
        return positionDAOImpl.findAll();
    }

    @Transactional
    @Override
    public void create(Position position) {
        positionDAOImpl.create(position);
    }

    @Transactional
    @Override
    public void update(Position position) {
        positionDAOImpl.update(position);
    }

    @Transactional
    @Override
    public void delete(Position position) {
        positionDAOImpl.delete(position);
    }

    @Transactional
    @Override
    public void delete(Integer pos_id) {
        positionDAOImpl.delete(pos_id);
    }

    @Transactional
    @Override
    public Position findEntityById(Integer pos_id) {
        return positionDAOImpl.findEntityById(pos_id);
    }


    public List<Position> orderPositionByPrice() {
        return positionDAOImpl.orderPositionByPrice();
    }


    public List<Position> orderBackPositionByPrice () {
        return positionDAOImpl.orderBackPositionByPrice();
    }

}




