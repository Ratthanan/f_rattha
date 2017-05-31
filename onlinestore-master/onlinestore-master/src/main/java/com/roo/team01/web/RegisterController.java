package com.roo.team01.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.LogUser;
import com.roo.team01.domain.LogUserRole;

@RequestMapping("/user")
@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register", produces = "text/html")
    public String viewRegister(Model uiModel){
		
		return "user/register";
    }
	
	@RequestMapping(value = "/createUser",method = RequestMethod.POST, produces = "text/html")
    public ResponseEntity<String> createUser(@Valid LogUser user, Model uiModel, HttpServletRequest request){
		if(user.getUsername() != "" && user.getPassword() != "" && user.getPhone() != ""){
			LogUser u = new LogUser();
			LogUserRole role = new LogUserRole();
			Customer c = new Customer();
			if(LogUserRole.findAllLogUserRoles().isEmpty()){
			
				role.setRoleName("ROLE_USER");
				role.persist();
				Set<LogUserRole> roles = new HashSet<LogUserRole>();
				roles.add(LogUserRole.findLogUserRole(Long.valueOf(1)));
				u.setRoles(roles);
			}else{
				role = LogUserRole.findLogUserRole(Long.valueOf(1));
				Set<LogUserRole> roles = new HashSet<LogUserRole>();
				roles.add(role);
				u.setRoles(roles);
		
			}
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setAddress(user.getAddress());
			u.setPhone(user.getPhone());  
			
			c.setUserName(user.getUsername());
			c.setPassword(user.getPassword());
			c.setAddress(user.getAddress());
			c.setPhone(user.getPhone());
			c.persist();
			u.persist();
			return new ResponseEntity<String>("user/register",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("user/register",HttpStatus.FOUND);
		}
    }
}
