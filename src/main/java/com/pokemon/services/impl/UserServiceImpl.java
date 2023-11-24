package com.pokemon.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pokemon.controller.request.CreateUserDTO;
import com.pokemon.controller.request.UpdateUserDTO;
import com.pokemon.models.RoleEntity;
import com.pokemon.models.UserEntity;
import com.pokemon.models.enums.ERole;
import com.pokemon.repository.RoleRepository;
import com.pokemon.repository.UserRepository;
import com.pokemon.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> findAllByRole(String rol) {
        return userRepository.findByRoles_Name(rol);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity save(CreateUserDTO userDTO) {

        Set<RoleEntity> roles = userDTO.getRoles().stream()
                .map(role -> {
                    Optional<RoleEntity> existingRole = roleRepository.findByName(ERole.valueOf(role));
                    return existingRole.orElseGet(() -> RoleEntity.builder()
                            .name(ERole.valueOf(role))
                            .build());
                })
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .roles(roles)
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .build();

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id, UpdateUserDTO userDTO) {

        UserEntity user = userRepository.findById(id).orElseThrow();

        Set<RoleEntity> roles = userDTO.getRoles().stream()
                .map(role -> {
                    Optional<RoleEntity> existingRole = roleRepository.findByName(ERole.valueOf(role));
                    return existingRole.orElseGet(() -> RoleEntity.builder()
                            .name(ERole.valueOf(role))
                            .build());
                })
                .collect(Collectors.toSet());

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        userRepository.deleteAllById(ids);
    }

}
