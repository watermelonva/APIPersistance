/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easylink.api.model;

import java.util.Objects;

/**
 *
 * @author ade
 */
public class ErrorReconciliation {

    private User user;
    private String message;
    private Double amountProvider;
    private Double amountATFP;
    private Double amountCash;
    private Double amountFree;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorReconciliation() {
    }

    public ErrorReconciliation(User user) {
        this.user = user;
    }

    public ErrorReconciliation(User user, Double amountProvider, Double amountATFP) {
        this.user = user;
        this.amountProvider = amountProvider;
        this.amountATFP = amountATFP;
    }

    public ErrorReconciliation(User user, String message, Double amountProvider, Double amountATFP) {
        this.user = user;
        this.message = message;
        this.amountProvider = amountProvider;
        this.amountATFP = amountATFP;
    }

    public ErrorReconciliation(User user, Double amountProvider) {
        this.user = user;
        this.amountProvider = amountProvider;
    }

    public Double getAmountProvider() {
        return amountProvider;
    }

    public void setAmountProvider(Double amountProvider) {
        this.amountProvider = amountProvider;
    }

    public Double getAmountATFP() {
        return amountATFP;
    }

    public void setAmountATFP(Double amountATFP) {
        this.amountATFP = amountATFP;
    }

    public Double getAmountCash() {
        return amountCash;
    }

    public void setAmountCash(Double amountCash) {
        this.amountCash = amountCash;
    }

    public Double getAmountFree() {
        return amountFree;
    }

    public void setAmountFree(Double amountFree) {
        this.amountFree = amountFree;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErrorReconciliation other = (ErrorReconciliation) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

 

}
