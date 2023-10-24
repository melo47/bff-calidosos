/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.example.demo.models.dto.response.product;

import com.example.demo.models.entity.BasicData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProductResponse {
    private BasicData basicData;
    private ProductUser products;
}
