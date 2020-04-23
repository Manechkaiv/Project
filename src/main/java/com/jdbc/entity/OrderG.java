package com.jdbc.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "orderofguest")
public class OrderG {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "ord_id", length = 6, nullable = false)
    private Integer ord_id;

    @OneToOne(optional = false)
    @JoinColumn(name="g_id", unique = true, nullable = false, updatable = false)
    private Guest guest;

    @OneToOne(optional = false)
    @JoinColumn(name="p_id", unique = true, nullable = false, updatable = false)
    private Position position;

    public OrderG(){
    }

    public OrderG(Integer ord_id, Guest guest, Position position) {
        this.ord_id = ord_id;
        this.guest = guest;
        this.position = position;

    }

    @Override
    public String toString() {
        return "Guest{" +
                "ord_id=" + ord_id +
                ", guest='" + guest +
                ", position=" + position +
                '}';
    }


    public Integer getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(Integer ord_id) {
        this.ord_id = ord_id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
