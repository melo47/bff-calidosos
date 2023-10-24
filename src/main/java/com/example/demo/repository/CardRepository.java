/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.repository;

import com.example.demo.models.entity.Card;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CardRepository {


    private final Connection dbConnection;

    @SneakyThrows
    public List<Card> getCardsUser(final String userName) {
        List<Card> cards = new ArrayList<>();
        try(PreparedStatement ps = dbConnection.prepareStatement("" +
                "SELECT c.product_name, c.card_number, c.expiration_date, c.ccv FROM users u inner join cards c on u.id = c.username_id where u.username = " + "'" + userName + "'")) {
            var result = ps.execute();

            if(result) {
                var resultSet = ps.getResultSet();
                while(resultSet.next()) {
                    cards.add(Card
                            .builder()
                            .productName(resultSet.getString("product_name"))
                            .id(resultSet.getString("card_number"))
                            .expirationDate(resultSet.getString("expiration_date"))
                            .ccv(resultSet.getString("ccv"))
                            .build());
                }

            }
        }
        return cards;
    }
}
