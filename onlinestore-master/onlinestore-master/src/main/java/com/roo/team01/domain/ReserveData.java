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
public class ReserveData {

    /**
     */
    @ManyToOne
    private Customer cid;

    /**
     */
    @ManyToOne
    private Product product;

    /**
     */
    @NotNull
    @DecimalMin("1")
    private Integer amount;

    /**
     */
    private String dates;

    /**
     */
    @Value("false")
    private Boolean status;

    /**
     */
    @Value("false")
    private Boolean cstatus;
}
