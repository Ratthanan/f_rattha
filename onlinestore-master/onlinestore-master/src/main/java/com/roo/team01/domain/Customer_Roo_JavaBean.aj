// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.LogUserRole;
import java.util.Set;

privileged aspect Customer_Roo_JavaBean {
    
    public String Customer.getUserName() {
        return this.userName;
    }
    
    public void Customer.setUserName(String userName) {
        this.userName = userName;
    }
    
    public String Customer.getPassword() {
        return this.password;
    }
    
    public void Customer.setPassword(String password) {
        this.password = password;
    }
    
    public String Customer.getPhone() {
        return this.phone;
    }
    
    public void Customer.setPhone(String phone) {
        this.phone = phone;
    }
    
    public String Customer.getAddress() {
        return this.address;
    }
    
    public void Customer.setAddress(String address) {
        this.address = address;
    }
    
    public Set<LogUserRole> Customer.getRoles() {
        return this.roles;
    }
    
    public void Customer.setRoles(Set<LogUserRole> roles) {
        this.roles = roles;
    }
    
    public Boolean Customer.getEnabled() {
        return this.enabled;
    }
    
    public void Customer.setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
}
