/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.models.dto.response.product;

import com.example.demo.models.entity.Card;
import com.example.demo.models.entity.Cdt;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductUser {
    private List<Cdt> cdt;
    private List<Card> cards;
}
