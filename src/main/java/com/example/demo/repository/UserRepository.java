/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.repository;

import com.example.demo.constants.ErrorMessageConstants;
import com.example.demo.models.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final Connection dbConnection;
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String USERNAME_ATTRIBUTE = "username";
    private static final String ROLE_ATTRIBUTE = "role";

    public List<User> getUser(final String username) throws SQLException {
        List<User> users = new ArrayList<>();

        try(PreparedStatement ps = dbConnection.prepareStatement("" +
                "SELECT * FROM users where username =" + "'" + username + "'")) {
            var result = ps.execute();

            if(result) {
                var resultSet = ps.getResultSet();
                while(resultSet.next()) {
                    var user = User
                            .builder()
                            .username(resultSet.getString(USERNAME_ATTRIBUTE))
                            .password(resultSet.getString(PASSWORD_ATTRIBUTE))
                            .role( resultSet.getString(ROLE_ATTRIBUTE)).build();
                    users.add(user);
                }
            }

        }
        return users;
    }

    public boolean validateAdmin(String username) throws SQLException {
        try(PreparedStatement ps = dbConnection.prepareStatement("" +
                "SELECT * FROM users where username =" + "'" + username + "' AND role = 'admin'")) {
            var result = ps.execute();

            if(result) {
                return true;
            } else {
                throw new RuntimeException(ErrorMessageConstants.FORBIDDEN_ACTION);
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try(PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM users")) {
            var result = ps.execute();

            if(result) {
                var resultSet = ps.getResultSet();
                while(resultSet.next()) {
                    var user = User
                            .builder()
                            .username(resultSet.getString(USERNAME_ATTRIBUTE))
                            .role( resultSet.getString(ROLE_ATTRIBUTE)).build();
                    users.add(user);
                }
            }
        }
        return users;
    }
}
