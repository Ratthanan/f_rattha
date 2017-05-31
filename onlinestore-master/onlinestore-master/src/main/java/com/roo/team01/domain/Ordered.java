package com.roo.team01.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Ordered {
    /**
     */
    private Float amount;

    /**
     */
    @ManyToOne
    private Customer customer;

    /**
     */
    @Value("false")
    private Boolean status;

    /**
     */
    @DecimalMin("1")
    @NotNull
    private Integer num;

    /**
     */
    @ManyToOne
    private Product products;

    /**
     */
    private String sendBy;

    /**
     */
    @Value("false")
    private Boolean warringStatus;
}
