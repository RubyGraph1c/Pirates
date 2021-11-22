package com.example.codeclan.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List; //DB insists List.

@Entity //an entity we want to persist
@Table(name="ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @JsonIgnoreProperties({"ship"}) //stops returned info from being mental.
    /*
    {"ship"} is a stopping point, so it doesn't loop indefinitely.
    Once pirates on given ship returned, ignore ship prop on pirates,
    just return pirates (we already know the ship) - it stops it looping altogether.
    Ensures what we get back what we're looking for rather than an info overload.
    */
    @OneToMany(mappedBy = "ship")
    private List<Pirate> pirates;
    /* private array list of Pirate object's called pirates */

    public Ship(String name) {
        this.name = name;
        //initialise blank list:
        this.pirates = new ArrayList<>();
    }

    public Ship(){
        //default constructor.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    //dont test getters and setters.
}
