/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.controller;

import com.example.demo.models.dto.Request;
import com.example.demo.models.dto.Response;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("calidosos")
@AllArgsConstructor
public class ControllerCl {

    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<Response> validateUser(@RequestBody Request rq){
        return ResponseEntity.ok(userService.validateUser(rq.getName(), rq.getPassword()));
    }

    @PostMapping("users")
    public ResponseEntity<Object> getAllUsers(@RequestBody Request rq) {
        return ResponseEntity.ok(userService.getUsers(rq.getName(), rq.getPassword()));
    }

}
