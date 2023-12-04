package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.models.Question;
import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByDificultId(Long dificultId);
}
