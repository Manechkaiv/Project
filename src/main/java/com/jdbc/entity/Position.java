package com.jdbc.entity;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @Column(name = "pos_id")
    private int pos_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    public Position(){
    }

    public Position(int pos_id, String name, int price) {
        this.pos_id = pos_id;
        this.name = name;
        this.price = price;
    }

   @Override
    public String toString() {
        return pos_id +
                " " + name +
                " " + price;
    }

    public int getPos_id() {
        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}