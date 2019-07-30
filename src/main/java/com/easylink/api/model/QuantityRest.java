/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

/**
 *
 * @author ade
 */
public class QuantityRest {
    private Integer quantity;
    private Integer rest;

    public QuantityRest() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "QuantityRest{" + "quantity=" + quantity + '}';
    }

    public QuantityRest(int quantity, int rest) {
        this.quantity = quantity;
        this.rest = rest;
    }
    
}
