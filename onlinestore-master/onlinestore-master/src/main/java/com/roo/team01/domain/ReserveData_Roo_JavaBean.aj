// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Product;
import com.roo.team01.domain.ReserveData;

privileged aspect ReserveData_Roo_JavaBean {
    
    public Customer ReserveData.getCid() {
        return this.cid;
    }
    
    public void ReserveData.setCid(Customer cid) {
        this.cid = cid;
    }
    
    public Product ReserveData.getProduct() {
        return this.product;
    }
    
    public void ReserveData.setProduct(Product product) {
        this.product = product;
    }
    
    public Integer ReserveData.getAmount() {
        return this.amount;
    }
    
    public void ReserveData.setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public String ReserveData.getDates() {
        return this.dates;
    }
    
    public void ReserveData.setDates(String dates) {
        this.dates = dates;
    }
    
    public Boolean ReserveData.getStatus() {
        return this.status;
    }
    
    public void ReserveData.setStatus(Boolean status) {
        this.status = status;
    }
    
    public Boolean ReserveData.getCstatus() {
        return this.cstatus;
    }
    
    public void ReserveData.setCstatus(Boolean cstatus) {
        this.cstatus = cstatus;
    }
    
}
