/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.services;

import com.example.demo.models.dto.response.product.ProductUser;
import com.example.demo.models.dto.response.product.UserProductResponse;
import com.example.demo.repository.BasicDataRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.CdtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProductsService {

    private final CdtRepository cdtRepository;
    private final BasicDataRepository basicDataRepository;
    private final CardRepository cardRepository;

    public UserProductResponse getProductsByUsername(final String userName) {
        return UserProductResponse.builder().products(
                        ProductUser.builder()
                                .cdt(cdtRepository.getCdtsUser(userName))
                                .cards(cardRepository.getCardsUser(userName))
                                .build())
                .basicData(basicDataRepository.getBasicDataUser(userName)).build();
    }
}
