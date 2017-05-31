package com.roo.team01.domain;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class PreOrder {

    /**
     */
	@NotNull
    private String name;

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
    private Boolean status;

    /**
     */
    private String uname;
}
