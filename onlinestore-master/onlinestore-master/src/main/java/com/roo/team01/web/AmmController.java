package com.roo.team01.web;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Delivery;
import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.Payment;
import com.roo.team01.domain.Product;
import com.roo.team01.domain.ReserveData;

@RequestMapping("/amm")
@Controller

public class AmmController {

	@RequestMapping(value = "/add", produces = "text/html")
	public String viewAdd(Model uiModel,HttpServletRequest request) {
		
		List<Payment> s = Payment.findAllPayments();
		uiModel.addAttribute("data", s);
		
		return "amm/add";
	
	}
	 
		@RequestMapping(value = "/show", produces = "text/html")
		public String viewdetal(Model uiModel) {
			
			return "amm/show";
		}
		
		@RequestMapping(value = "/deliveried",method = RequestMethod.POST, produces = "text/html")
	    public ResponseEntity<String> createUser(@Valid Delivery d, Model uiModel, HttpServletRequest request){
	    System.out.println(request.getParameterMap());
	    if(!(request.getParameter("note").isEmpty())){
	      Delivery d1 = new Delivery();
	      
	      Payment p = Payment.findPayment(d.getPayment().getId());
	      Boolean b = true;
	      d1.setPayment(p);
	      d1.setNote(d.getNote());
	      d1.setStatus(b);
	      p.setSendStatus(true);
	      p.persist();
	      d1.persist();
			return new ResponseEntity<String>("amm/show",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("amm/show",HttpStatus.FOUND);
	    }
	    }
		
		  public String getSessionName(HttpServletRequest request){
			    String ses = request.getUserPrincipal().toString();
			    int indexS = ses.indexOf("Username:")+10;
			    int indexE = ses.indexOf("Password:")-2;
			    String uname = ses.substring(indexS, indexE);
			    return uname;
			  }
		  
		  @RequestMapping(value = "/viewUser", produces = "text/html")
		    public String viewAdd1(Model uiModel, HttpServletRequest request) {
		    
			  List<Delivery> d = Delivery.findAllDeliverys();
			  List<Delivery> d1 =new ArrayList<Delivery>();
		    String uname1 = getSessionName(request);
		    for(Delivery a : d)
		    	if(a.getPayment().getOrdered().getCustomer().getUserName().equals(uname1))
		    			d1.add(a);
		    
		    
		      uiModel.addAttribute("p1", d1);

		        return "amm/viewUser";
		    }
		  
		  @RequestMapping(value = "/check", produces = "text/html")
			public String checktrack(@Valid Delivery d,Model uiModel,HttpServletRequest request) {
			  List<Delivery> f = Delivery.findAllDeliverys();
			
				for(Delivery a : f)
					if(a.getId() == d.getId())
						uiModel.addAttribute("result", a);
				
				return "amm/check";
			
			}
		
		

}
