package com.roo.team01.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Payment {

    /**
     */
	@NotNull
    private String account;

    /**
     */
	@NotNull
    private String dates;

    /**
     */
	@NotNull
    private String times;

    /**
     */
	@NotNull
    private Float amount;

    /**
     */
    @ManyToOne
    private Ordered ordered;

    /**
     */
    @Value("false")
    private Boolean status;

    /**
     */
    @Value("false")
    private Boolean sendStatus;
}
