package com.jdbc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "gst_id", length = 6, nullable = false)
    private Integer gst_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public Guest(){
    }

   public Guest(Integer gst_id, String firstName, String lastName) {
        this.gst_id = gst_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "gst_id=" + gst_id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                '}';
    }


    public Integer getId() {
        return gst_id;
    }

    public void setId(Integer gst_id) {
        this.gst_id = gst_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
