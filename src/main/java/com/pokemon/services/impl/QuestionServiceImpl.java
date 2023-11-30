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
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> saveAll(List<Question> questions) {
        System.out.println(questions);
        return questionRepository.saveAll(questions);
    }

    @Override
    public Question update(Long id, Question question) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
