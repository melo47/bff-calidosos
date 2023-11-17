/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.services;

import com.example.demo.constants.ErrorMessageConstants;
import com.example.demo.constants.ServiceConstants;
import com.example.demo.models.dto.response.login.LoginResponse;
import com.example.demo.models.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    @SneakyThrows
    public LoginResponse validateUser(final String username, final String password) {
        var list = userRepository.getUser(username);

        if(isInjectionDone()) {
            return LoginResponse.builder().message(ServiceConstants.CAPTURED_FLAG).build();
        }

        if(list.isEmpty()) {
            throw new RuntimeException(ErrorMessageConstants.USER_PASSWORD_INVALID);
        }

        return LoginResponse.builder().message(ServiceConstants.AUTHENTICATED_USER).build();
    }

    @SneakyThrows
    public List<User> getUsers(final String username, String pass) {
        validateUser(username, pass);
        userRepository.validateAdmin(username);
        return userRepository.getAllUsers();
    }

    @SneakyThrows
    private boolean isInjectionDone() {
        return userRepository.getAllUsers().isEmpty();

    }
}
