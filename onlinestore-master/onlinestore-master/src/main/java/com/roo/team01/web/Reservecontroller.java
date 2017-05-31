package com.roo.team01.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.PreOrder;
import com.roo.team01.domain.Product;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Product;
import com.roo.team01.domain.ReserveData;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.ui.Model;



@RooJavaBean
@RooToString
@RequestMapping("/fluwe")
@Controller
public class Reservecontroller {
  
  @RequestMapping(value = "/add", produces = "text/html")
    public String viewAdd(Model uiModel, HttpServletRequest request) {
    List<Product> p = Product.findAllProducts();
    String uname1 = getSessionName(request);
    Date currentDate = GregorianCalendar.getInstance().getTime();
    String output = new DateTime(currentDate).toString("yyyy-MM-dd");
    uiModel.addAttribute("dates", output);
      uiModel.addAttribute("p1", uname1);
    uiModel.addAttribute("p", p);
    
        return "fluwe/add";
    }

    @RequestMapping(value = "/show", produces = "text/html")
    public String viewShow(Model uiModel ,HttpServletRequest request) {
    List<ReserveData> p = ReserveData.findAllReserveDatas();
    List<ReserveData> p1 = new ArrayList<ReserveData>();
    String s = getSessionName(request);
    for(ReserveData a : p)
    	if(a.getCid().getUserName().equals(s))
    			p1.add(a);
    
        uiModel.addAttribute("data", p1);
        return "fluwe/show";
    }
    
    @RequestMapping(value = "/pshow", produces = "text/html")
    public String viewpShowUser(Model uiModel ,HttpServletRequest request) {
    	 List<PreOrder> p = PreOrder.findAllPreOrders();
    	    List<PreOrder> p1 = new ArrayList<PreOrder>();
    	    String s = getSessionName(request);
    	    for(PreOrder a : p)
    	    	if(a.getUname().equals(s))
    	    			p1.add(a);
    	    uiModel.addAttribute("data", p1);
        return "fluwe/pshow";
    }
    
 
    @RequestMapping(value = "/createReserve",method = RequestMethod.POST, produces = "text/html")
    public String createUser(@Valid ReserveData r, Model uiModel, HttpServletRequest request){
    System.out.println(r.getAmount());
      ReserveData re = new ReserveData();
      
      Date currentDate = GregorianCalendar.getInstance().getTime();
       String output = new DateTime(currentDate).toString("yyyy-MM-dd");
	       
	       Product p = Product.findProduct(r.getProduct().getId());
	       String s = getSessionName(request);
	       List<Customer> l = Customer.findAllCustomers();
	       Boolean b = false;
	      
	       
	       for(Customer a : l){
	    	   if(a.getUserName().equals(s))
	    		   re.setCid(a);
	       }
	       
	    
	    	re.setStatus(b);
	        re.setProduct(p);
	        re.setAmount(r.getAmount());
	        re.setDates(output);
	        re.persist();
	        
	        p.setAmount(p.getAmount()-r.getAmount());
	        p.persist();
		
			return "fluwe/add";
		
    } 
    
    public String getSessionName(HttpServletRequest request){
    String ses = request.getUserPrincipal().toString();
    int indexS = ses.indexOf("Username:")+10;
    int indexE = ses.indexOf("Password:")-2;
    String uname = ses.substring(indexS, indexE);
    return uname;
  }
   
    
    @RequestMapping(value = "/showadmin", produces = "text/html")
    public String showaddmin(Model uiModel, HttpServletRequest request) {
    	List<ReserveData> p = ReserveData.findAllReserveDatas();
    	uiModel.addAttribute("data", p);
    
        return "fluwe/showadmin";
    }
    
    @RequestMapping(value = "/PreOrder", produces = "text/html")
    public String padd(Model uiModel,@Valid PreOrder p, HttpServletRequest request) {
    	PreOrder pre = new PreOrder();
    	String uname1 = getSessionName(request);
        Date currentDate = GregorianCalendar.getInstance().getTime();
        String output = new DateTime(currentDate).toString("yyyy-MM-dd");
    
    	pre.setUname(uname1);
    	pre.setName(p.getName());
    	pre.setAmount(p.getAmount());
    	pre.setDates(output);
    	pre.setStatus(false);
    	pre.persist();
    	
    
    	
    
    	
        return "fluwe/padd";
    }
    
    
    @RequestMapping(value = "/padd", produces = "text/html")
    public String padd1(Model uiModel, HttpServletRequest request) {
    	  String uname1 = getSessionName(request);
    	  Date currentDate = GregorianCalendar.getInstance().getTime();
          String output = new DateTime(currentDate).toString("yyyy-MM-dd");
    		uiModel.addAttribute("p1", uname1);
    		
    		uiModel.addAttribute("dates", output);
        return "fluwe/padd";
    }
    
   
    
    
    @RequestMapping(value = "/pshow_admin", produces = "text/html")
    public String pshow(Model uiModel, HttpServletRequest request) {
    	List<PreOrder> p = PreOrder.findAllPreOrders();
    	String uname1 = getSessionName(request);
    	uiModel.addAttribute("data", p);
    	uiModel.addAttribute("user", uname1);
    	
    
        return "fluwe/pshow_admin";
    }
    
    
    @RequestMapping(value = "/persistOrder",method = RequestMethod.GET,produces = "text/html")
    public String deleteOrder(Model uiModel, @RequestParam(value = "idreserve", required = false) String idreserve){
       
    	ReserveData re = ReserveData.findReserveData(Long.valueOf(idreserve));
    	Ordered or = new Ordered();
    	
    	
    	or.setProducts(re.getProduct());
    	or.setCustomer(re.getCid());
    	or.setNum(re.getAmount());
    	or.setAmount(re.getAmount()*re.getProduct().getPrice());
    	or.setStatus(false);
    	or.setSendBy("EMS");
    	//or.setwarningstatus//
    	or.persist();
    	
    	re.remove();
    	re.persist();
    	
        return "fluwe/showadmin";
    }
    
    @RequestMapping(value = "/changeStatus",method = RequestMethod.GET,produces = "text/html")
    public String changeStatus(Model uiModel, @RequestParam(value = "change", required = false) String change){
       
    	PreOrder re = PreOrder.findPreOrder(Long.valueOf(change));
    		
    		re.setStatus(true);
    	
    	
    		re.persist();
    	
        return "fluwe/pshow_admin";
    }
   
    
    
    
}






