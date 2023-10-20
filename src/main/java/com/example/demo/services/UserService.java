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
import com.example.demo.models.dto.Response;
import com.example.demo.models.dto.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @SneakyThrows
    public Response validateUser(final String username, final String password) {
        var list = userRepository.getUser(username);

        if(isInjectionDone()) {
            return Response.builder().message(ServiceConstants.CAPTURED_FLAG).build();
        }

        if(list.isEmpty()) {
            throw new RuntimeException(ErrorMessageConstants.USER_PASSWORD_INVALID);
        }

        if(!list.get(0).getPassword().equals(password)) {
            throw new RuntimeException(ErrorMessageConstants.USER_PASSWORD_INVALID);
        }

        return Response.builder().message(ServiceConstants.AUTHENTICATED_USER).build();
    }

    @SneakyThrows
    public List<User> getUsers(final String username, String pass) {
        validateUser(username, pass);
        userRepository.validateAdmin(username);
        return userRepository.getAllUsers();
    }

    @SneakyThrows
    private boolean isInjectionDone() {
        List<User> users = userRepository.getAllUsers();
        try(BufferedReader  bf = new BufferedReader(new FileReader(ServiceConstants.DATA_RECORD_FILE_SQL))) {
            long recordsInFile = bf.lines().count();
            long usersInDatabase = users.size();
            log.info("Records File {}", recordsInFile);
            log.info("records DB {} ", usersInDatabase);
            return recordsInFile > usersInDatabase;
        }
    }
}
