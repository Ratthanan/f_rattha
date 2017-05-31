// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.PreOrder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PreOrder_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager PreOrder.entityManager;
    
    public static final List<String> PreOrder.fieldNames4OrderClauseFilter = java.util.Arrays.asList("name", "amount", "dates", "status", "uname");
    
    public static final EntityManager PreOrder.entityManager() {
        EntityManager em = new PreOrder().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PreOrder.countPreOrders() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PreOrder o", Long.class).getSingleResult();
    }
    
    public static List<PreOrder> PreOrder.findAllPreOrders() {
        return entityManager().createQuery("SELECT o FROM PreOrder o", PreOrder.class).getResultList();
    }
    
    public static List<PreOrder> PreOrder.findAllPreOrders(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreOrder o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreOrder.class).getResultList();
    }
    
    public static PreOrder PreOrder.findPreOrder(Long id) {
        if (id == null) return null;
        return entityManager().find(PreOrder.class, id);
    }
    
    public static List<PreOrder> PreOrder.findPreOrderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PreOrder o", PreOrder.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<PreOrder> PreOrder.findPreOrderEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreOrder o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreOrder.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void PreOrder.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PreOrder.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PreOrder attached = PreOrder.findPreOrder(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PreOrder.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PreOrder.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PreOrder PreOrder.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PreOrder merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}