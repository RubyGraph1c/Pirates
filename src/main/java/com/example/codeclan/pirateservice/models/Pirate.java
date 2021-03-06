package com.example.codeclan.pirateservice.models;
// POJO.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //select persistence option for both.
@Table(name="pirates") //Name: plural of class.

public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //auto incremented value generated by DB.
    @Column(name = "id")
    private Long id;
    //Primary key. Not passed into normal constructor. Needs G+S.
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    //connecting ship property - whenever we create a pirate instance it must have a ship_id
    private Ship ship;

    @ManyToMany
    @JsonIgnoreProperties({"pirates"})
    //stops looping: we want to ignore the pirates props of raid.
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    //if one side changes, the other side updates too.



    @JoinTable(
            name = "pirates_raids",
            joinColumns = { @JoinColumn(
                   name = "pirate_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            }
    )


    private List<Raid> raids;

    //generate constructor:
    public Pirate(String firstName, String lastName, int age, Ship ship) {
        /*
        NB: id not passed in.
        NB: remember that you need to state type first - in this case the type is Ship ("Ship ship" above).
         */
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }


    //default constructor:
    public Pirate(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //generate getters and setters:
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Raid> getRaids() {
        return raids;
    }

    public void setRaids(List<Raid> raids) {
        this.raids = raids;
    }

    public void addRaid(Raid raid){
        this.raids.add(raid);
    }
}

/*
POJO: Plain Old Java Object.
1. Getters and setters
2. Default constructor
3. ID of type long (a big integer) with G+S.
 */