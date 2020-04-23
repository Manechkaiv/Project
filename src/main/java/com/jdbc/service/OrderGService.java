package com.jdbc.service;

import com.jdbc.entity.OrderG;
import java.util.List;

public interface OrderGService {

    List<OrderG> findAll();
    void create(OrderG orderG);
    void delete(OrderG orderG);
    void delete(Integer ord_id);
    void update(OrderG orderG);
    OrderG findEntityById(Integer ord_id);

}
