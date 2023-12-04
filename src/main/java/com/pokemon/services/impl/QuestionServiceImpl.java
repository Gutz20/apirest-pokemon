package com.pokemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.models.Question;
import com.pokemon.repository.QuestionRepository;
import com.pokemon.services.IQuestionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAllByDificult(Long dificultId) {
        return questionRepository.findByDificultId(dificultId);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> saveAll(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    @Override
    public Question update(Long id, Question question) {

        Question questionFound = questionRepository.findById(id).orElseThrow();

        questionFound.setAnswers(question.getAnswers());
        questionFound.setCode(question.getCode());
        questionFound.setCorrectAnswer(question.getCorrectAnswer());
        questionFound.setDificult(question.getDificult());
        questionFound.setQuestion(question.getQuestion());
        questionFound.setTrack(question.getTrack());

        return questionFound;
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> idsList) {
        questionRepository.deleteAllById(idsList);
    }

}
