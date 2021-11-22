package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositories should be interfaces. Inherits from JPA repo.
@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
    //Inherits functionality from JPA repo, but does not modify it.
    //need to tell it type of ID (Long)
}




