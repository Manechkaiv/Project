package com.jdbc.service;

import com.jdbc.entity.Position;
import java.util.List;

public interface PositionService {

    List<Position> findAll();
    void create(Position position);
    void delete(Position position);
    void delete(Integer pos_id);
    void update(Position position);
    Position findEntityById(Integer pos_id);
    List<Position> orderPositionByPrice();
    List<Position> orderBackPositionByPrice ();

}

