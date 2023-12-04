package com.pokemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.models.Dificult;
import com.pokemon.repository.DificultRepository;
import com.pokemon.services.IDificultService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DificultServiceImpl implements IDificultService {

    @Autowired
    private DificultRepository dificultRepository;

    @Override
    public List<Dificult> findAll() {
        return dificultRepository.findAll();
    }

    @Override
    public Dificult findById(Long id) {
        return dificultRepository.findById(id).orElseThrow();
    }

    @Override
    public Dificult save(Dificult dificult) {
        return dificultRepository.save(dificult);
    }

    @Override
    public List<Dificult> saveAll(List<Dificult> dificults) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Dificult update(Long id, Dificult dificult) {
        Dificult dificultFound = dificultRepository.findById(id).orElseThrow();

        dificultFound.setName(dificult.getName());

        return dificultRepository.save(dificultFound);
    }

    @Override
    public void deleteById(Long id) {
        dificultRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> idsList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

}
