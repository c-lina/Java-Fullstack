package com.revature.DAOs;

import com.revature.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDAO extends JpaRepository<Pet, Integer> {
}
