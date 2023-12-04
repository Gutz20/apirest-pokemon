package com.pokemon.services;

import java.util.List;

import com.pokemon.models.Dificult;

public interface IDificultService {
    List<Dificult> findAll();

    Dificult findById(Long id);

    Dificult save(Dificult dificult);

    List<Dificult> saveAll(List<Dificult> dificults);

    Dificult update(Long id, Dificult dificult);

    void deleteById(Long id);

    void deleteAllById(List<Long> idsList);
}
