package com.jdbc.service.impl;

import com.jdbc.dao.AbstractDAO;
import com.jdbc.dao.GuestDAOImpl;
import com.jdbc.entity.Guest;
import com.jdbc.service.GuestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestDAOImpl guestDAOImpl = new GuestDAOImpl();

    @Transactional
    @Override
    public List<Guest> findAll() {
        return guestDAOImpl.findAll();
    }

    @Transactional
    @Override
    public void create(Guest guest) {
        guestDAOImpl.create(guest);
    }

    @Transactional
    @Override
    public int getAllNumber() {
        return guestDAOImpl.getAllNumber();
    }

    @Transactional
    @Override
    public void update(Guest guest) {
        guestDAOImpl.update(guest);
    }

    @Transactional
    @Override
    public void delete(Guest guest) {
        guestDAOImpl.delete(guest);
    }

    @Transactional
    @Override
    public void delete(Integer gst_id) {
        guestDAOImpl.delete(gst_id);
    }

    @Transactional
    @Override
    public Guest findEntityById(Integer gst_id) {
        return guestDAOImpl.findEntityById(gst_id);
    }

}