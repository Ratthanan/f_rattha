// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.ReserveData;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect ReserveData_Roo_Jpa_Entity {
    
    declare @type: ReserveData: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ReserveData.id;
    
    @Version
    @Column(name = "version")
    private Integer ReserveData.version;
    
    public Long ReserveData.getId() {
        return this.id;
    }
    
    public void ReserveData.setId(Long id) {
        this.id = id;
    }
    
    public Integer ReserveData.getVersion() {
        return this.version;
    }
    
    public void ReserveData.setVersion(Integer version) {
        this.version = version;
    }
    
}
