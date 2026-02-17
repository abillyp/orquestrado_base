package com.billy.orchestrator.application.core.domain;

import com.billy.orchestrator.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Inventory {

    public Inventory() {
    }

    public Inventory(Integer id, Integer productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    private Integer id;

    private Integer productId;

    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
