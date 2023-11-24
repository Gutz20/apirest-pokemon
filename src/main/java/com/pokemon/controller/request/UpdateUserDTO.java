package com.pokemon.controller.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    private String email;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Set<String> roles;
}
