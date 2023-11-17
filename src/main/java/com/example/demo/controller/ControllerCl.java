/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.controller;

import com.example.demo.constants.ServiceConstants;
import com.example.demo.models.dto.request.login.LoginRequest;
import com.example.demo.models.dto.request.product.UserProductsRequest;
import com.example.demo.models.dto.response.login.LoginResponse;
import com.example.demo.models.dto.response.product.UserProductResponse;
import com.example.demo.services.LoginService;
import com.example.demo.services.UserProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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

    private final LoginService loginService;
    private final UserProductsService userProductsService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> validateUser(@RequestBody LoginRequest rq){
        return ResponseEntity.ok(loginService.validateUser(rq.getName(), rq.getPassword()));
    }

    @PostMapping("users")
    public ResponseEntity<Object> getAllUsers(@RequestBody LoginRequest rq) {
        return ResponseEntity.ok(loginService.getUsers(rq.getName(), rq.getPassword()));
    }

    @PostMapping("products")
    public ResponseEntity<UserProductResponse> validateUser(@RequestBody UserProductsRequest rq){
        return ResponseEntity.ok(userProductsService.getProductsByUsername(rq.getName()));
    }

    @PostMapping("validate-otp")
    public ResponseEntity<String> validateOtp(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(ServiceConstants.EMPTY_RESPONSE);
    }
}
