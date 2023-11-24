package com.pokemon.services;

import java.util.List;

import com.pokemon.controller.request.CreateUserDTO;
import com.pokemon.controller.request.UpdateUserDTO;
import com.pokemon.models.UserEntity;

public interface IUserService {
    List<UserEntity> findAll();

    List<UserEntity> findAllByRole(String rol);

    UserEntity findById(Long id);

    UserEntity findByUsername(String username);

    UserEntity save(CreateUserDTO userDTO);

    UserEntity update(Long id, UpdateUserDTO userDTO);

    void deleteById(Long id);

    void deleteAllById(List<Long> ids);
}
