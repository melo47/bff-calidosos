/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class H2DBConnection {

    private static final String DB_URL = "jdbc:h2:mem:testdb";
    private static final String USER_CREDENTIAL = "sa";
    private static final String PASSWORD_CREDENTIAL = "password";

    @Bean
    private static Connection initDBConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER_CREDENTIAL, PASSWORD_CREDENTIAL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}