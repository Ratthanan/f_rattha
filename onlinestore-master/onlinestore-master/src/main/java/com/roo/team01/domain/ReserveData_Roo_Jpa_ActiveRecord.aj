// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.domain;

import com.roo.team01.domain.ReserveData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ReserveData_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ReserveData.entityManager;
    
    public static final List<String> ReserveData.fieldNames4OrderClauseFilter = java.util.Arrays.asList("cid", "product", "amount", "dates", "status", "cstatus");
    
    public static final EntityManager ReserveData.entityManager() {
        EntityManager em = new ReserveData().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ReserveData.countReserveDatas() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ReserveData o", Long.class).getSingleResult();
    }
    
    public static List<ReserveData> ReserveData.findAllReserveDatas() {
        return entityManager().createQuery("SELECT o FROM ReserveData o", ReserveData.class).getResultList();
    }
    
    public static List<ReserveData> ReserveData.findAllReserveDatas(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ReserveData o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ReserveData.class).getResultList();
    }
    
    public static ReserveData ReserveData.findReserveData(Long id) {
        if (id == null) return null;
        return entityManager().find(ReserveData.class, id);
    }
    
    public static List<ReserveData> ReserveData.findReserveDataEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ReserveData o", ReserveData.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<ReserveData> ReserveData.findReserveDataEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ReserveData o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ReserveData.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ReserveData.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ReserveData.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ReserveData attached = ReserveData.findReserveData(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ReserveData.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ReserveData.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ReserveData ReserveData.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ReserveData merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}