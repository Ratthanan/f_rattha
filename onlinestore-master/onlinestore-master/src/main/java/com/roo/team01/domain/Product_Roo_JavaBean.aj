// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.Product;

privileged aspect Product_Roo_JavaBean {
    
    public String Product.getName() {
        return this.name;
    }
    
    public void Product.setName(String name) {
        this.name = name;
    }
    
    public Float Product.getPrice() {
        return this.price;
    }
    
    public void Product.setPrice(Float price) {
        this.price = price;
    }
    
    public String Product.getDetail() {
        return this.detail;
    }
    
    public void Product.setDetail(String detail) {
        this.detail = detail;
    }
    
    public Integer Product.getAmount() {
        return this.amount;
    }
    
    public void Product.setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public Boolean Product.getProStatus() {
        return this.proStatus;
    }
    
    public void Product.setProStatus(Boolean proStatus) {
        this.proStatus = proStatus;
    }
    
}
