package com.roo.team01.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Stock_bill {

    /**
     */
	@NotNull
    private String product_name;

    /**
     */
	@NotNull
    private Integer product_num;

    /**
     */
	@NotNull
    private String allproduct_price;

    /**
     */
    private Boolean status;

    /**
     */
    @NotNull
    private String date_pro;
}
