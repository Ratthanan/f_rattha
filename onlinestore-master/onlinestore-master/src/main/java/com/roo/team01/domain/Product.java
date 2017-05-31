package com.roo.team01.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findProductsByNameLike" })
public class Product {

    /**
     */
    @NotNull
    private String name;

    /**
     */
    @NotNull
    private Float price;

    /**
     */
    private String detail;

    /**
     */
    @DecimalMin("1")
    @NotNull
    private Integer amount;

    /**
     */
    @Value("false")
    private Boolean proStatus;
}
