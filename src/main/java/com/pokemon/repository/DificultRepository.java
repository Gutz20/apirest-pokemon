package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.models.Dificult;

@Repository
public interface DificultRepository extends JpaRepository<Dificult, Long> {

}
