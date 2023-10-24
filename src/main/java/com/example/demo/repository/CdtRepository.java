/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.repository;

import com.example.demo.models.entity.Cdt;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CdtRepository {


    private final Connection dbConnection;

    @SneakyThrows
    public List<Cdt> getCdtsUser(final String userName) {
        List<Cdt> cdts = new ArrayList<>();
        try(PreparedStatement ps = dbConnection.prepareStatement("" +
                "SELECT t.product_name, t.amount, t.init_date, t.end_date, t.rate  FROM users u inner join cdts t on u.id = t.username_id where u.username = " + "'" + userName + "'")) {
            var result = ps.execute();

            if(result) {
                var resultSet = ps.getResultSet();
                while(resultSet.next()) {
                    cdts.add(Cdt
                            .builder()
                            .productName(resultSet.getString("product_name"))
                            .amount(resultSet.getString("amount"))
                            .initDate(resultSet.getString("init_date"))
                            .endDate(resultSet.getString("end_date"))
                            .rate(resultSet.getString("rate"))
                            .build());
                }

            }
        }
        return cdts;
    }


}
