/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.repository;

import com.example.demo.models.entity.BasicData;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
@AllArgsConstructor
public class BasicDataRepository {

    private final Connection dbConnection;

    @SneakyThrows
    public BasicData getBasicDataUser(final String userName) {
        BasicData basicData = BasicData.builder().build();
        try(PreparedStatement ps = dbConnection.prepareStatement("" +
                "SELECT full_name, identification_id FROM users u inner join basic_data d on u.id = d.username_id where u.username =" + "'" + userName + "'")) {
            var result = ps.execute();

            if(result) {
                var resultSet = ps.getResultSet();
                resultSet.next();
                basicData = BasicData
                            .builder()
                            .username(userName)
                            .fullName(resultSet.getString("full_name"))
                            .identificationId( resultSet.getString("identification_id")).build();
            }
        }
        return basicData;
    }


}
