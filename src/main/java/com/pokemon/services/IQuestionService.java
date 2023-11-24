package com.pokemon.services;

import java.util.List;

import com.pokemon.models.Question;

public interface IQuestionService {
    List<Question> findAll();

    Question findById(Long id);

    Question save(Question question);

    Question update(Long id, Question question);

    void deleteById(Long id);

    void deleteAllById(List<Long> idsList);
}
