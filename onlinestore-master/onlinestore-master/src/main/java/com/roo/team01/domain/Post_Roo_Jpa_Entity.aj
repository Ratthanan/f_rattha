// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.Post;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Post_Roo_Jpa_Entity {
    
    declare @type: Post: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Post.id;
    
    @Version
    @Column(name = "version")
    private Integer Post.version;
    
    public Long Post.getId() {
        return this.id;
    }
    
    public void Post.setId(Long id) {
        this.id = id;
    }
    
    public Integer Post.getVersion() {
        return this.version;
    }
    
    public void Post.setVersion(Integer version) {
        this.version = version;
    }
    
}
