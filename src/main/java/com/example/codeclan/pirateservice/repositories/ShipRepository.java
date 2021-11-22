package com.example.codeclan.pirateservice.repositories;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
 /*
 1. New java class
 2. New interface/repo
 3. New controller
  */