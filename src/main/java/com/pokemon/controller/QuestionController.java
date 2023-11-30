package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.models.Question;
import com.pokemon.services.IQuestionService;

@RestController
@RequestMapping("api/v1/questions")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping()
    public ResponseEntity<List<Question>> getAll() {
        try {
            return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getOne(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Question> create(@RequestBody Question dto) {
        try {
            return new ResponseEntity<>(questionService.save(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createMany")
    public ResponseEntity<List<Question>> createMany(@RequestBody List<Question> questions) {
        try {
            List<Question> savedQuestions = questionService.saveAll(questions);
            return new ResponseEntity<>(savedQuestions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable(value = "id") Long id, @RequestBody Question dto) {
        try {
            return new ResponseEntity<>(questionService.update(id, dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable(value = "id") Long id) {
        try {
            questionService.deleteById(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMany")
    public ResponseEntity<String> destroy(@RequestBody List<Long> categoryIds) {
        try {
            questionService.deleteAllById(categoryIds);
            return new ResponseEntity<>("Destroy Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
