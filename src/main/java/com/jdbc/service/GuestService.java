package com.jdbc.service;

import com.jdbc.entity.Guest;
import java.util.List;

public interface GuestService {

    List<Guest> findAll();
    void create(Guest guest);
    void delete(Guest guest);
    void delete(Integer gst_id);
    void update(Guest guest);
    Guest findEntityById(Integer gst_id);
    int getAllNumber();
}

