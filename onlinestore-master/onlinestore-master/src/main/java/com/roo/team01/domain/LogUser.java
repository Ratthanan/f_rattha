package com.roo.team01.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Value;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class LogUser {

    /**
     */
    private String username;

    /**
     */
    private String password;

    /**
     */
    private String firstname;

    /**
     */
    private String lastname;

    /**
     */
    private String phone;

    /**
     */
    private String address;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<LogUserRole> roles = new HashSet<LogUserRole>();

    /**
     */
    @Value("true")
    private Boolean enabled;
}
