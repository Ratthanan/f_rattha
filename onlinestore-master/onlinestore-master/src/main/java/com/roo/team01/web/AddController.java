package com.roo.team01.web;
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

import com.roo.team01.domain.Add_Promotion;
import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.Product;
import com.roo.team01.domain.Promotion;
import com.roo.team01.domain.ReserveData;

@RequestMapping("/page1")
@Controller

public class AddController {

	@RequestMapping(value = "/add", produces = "text/html")
	public String viewAdd(Model uiModel) {
		List<Promotion> listpromotion = Promotion.findAllPromotions();
		uiModel.addAttribute("listpromotion", listpromotion);
	
		return "page1/add";
	
	}
	@RequestMapping(value = "/buypromotion", produces = "text/html")
	public String viewBuy(Model uiModel) {

		return "page1/buypromotion";
	
	}
	@RequestMapping(value = "/allproduct", produces = "text/html")
	public String viewAllProduct(Model uiModel) {
		List<Product> listproduct = Product.findAllProducts();
		uiModel.addAttribute("listproduct", listproduct);
		List<Add_Promotion> listadd = Add_Promotion.findAllAdd_Promotions();
		uiModel.addAttribute("listadd", listadd);
		return "page1/allproduct";
	
	}
	
	@RequestMapping(value = "/promotion", produces = "text/html")
	public String viewAdd1(Model uiModel) {
		List<Add_Promotion> a = Add_Promotion.findAllAdd_Promotions();
		uiModel.addAttribute("pro", a);
		return "page1/promotion";
	
	}
	 
		@RequestMapping(value = "/detal", produces = "text/html")
		public String viewdetal(Model uiModel) {
			List<Promotion> listpromotion = Promotion.findAllPromotions();
			uiModel.addAttribute("listpromotion", listpromotion);
			return "page1/detal";
		}
		
		@RequestMapping(value = "/addpro",method = RequestMethod.POST, produces = "text/html")
	    public String creatPro(@Valid Promotion p, Model uiModel, HttpServletRequest request){
	   
	      Promotion p1 = new Promotion();
	      if(p.getName() != null && p.getDiscount()!=null){
	      p1.setName(p.getName());
	      p1.setDetail(p.getDetail());
	      p1.setDiscount(p.getDiscount());
	      p1.persist();
	      }
	    return "page1/detal";
	    } 
		
		@RequestMapping(value = "/productPromotion",method = RequestMethod.POST, produces = "text/html")
	    public String productPromotion(@Valid Add_Promotion p, Model uiModel, HttpServletRequest request){
		   
		      Add_Promotion p1 = new Add_Promotion();
		      
		      if(p.getPromotion().getId() != 0){
		    	  Product pro = Product.findProduct(p.getProduct().getId());
		    	  Promotion promotion = Promotion.findPromotion(p.getPromotion().getId());
		    	  p1.setProduct(pro);
		    	  p1.setPromotion(promotion);
		    	  pro.setProStatus(true);
		    	  pro.persist();
		    	  p1.persist();
		      }
		      return "page1/add";
	    } 
		
		@RequestMapping(value = "/buyProductPromotion",method = RequestMethod.POST, produces = "text/html")
	    public ResponseEntity<String> buyProductPromotion(Model uiModel, HttpServletRequest request){
			System.out.println(request.getParameterMap());
			if(!(request.getParameter("num").isEmpty())){
				
				Ordered ord = new Ordered();
				String user = getSessionName(request);
				List<Customer> l = Customer.findAllCustomers();
				for(Customer c : l){
			    	   if(c.getUserName().equals(user))
			    		   ord.setCustomer(c);
			    }
				Add_Promotion promotion = Add_Promotion.findAdd_Promotion(Long.valueOf(request.getParameter("pro")));
				float discount = Float.valueOf(request.getParameter("discount"));
				int num = Integer.valueOf(request.getParameter("num"));
				
				if(discount == 100 && num == 1){
					
					Product p = Product.findProduct(promotion.getProduct().getId());
					float price = promotion.getProduct().getPrice();
					ord.setSendBy(request.getParameter("sendBy"));
					p.setAmount(p.getAmount()-2);
					ord.setProducts(p);
					ord.setNum(2);
					ord.setAmount(price);
					ord.setStatus(false);
					ord.persist();
					p.persist();
					
				}else{
					Product p = Product.findProduct(promotion.getProduct().getId());
					float price = promotion.getProduct().getPrice();
					float amount = ((100-discount)*price/100)*num;
					ord.setSendBy(request.getParameter("sendBy"));
					p.setAmount(p.getAmount()-num);
					ord.setProducts(p);
					ord.setNum(num);
					ord.setAmount(amount);
					ord.setStatus(false);
					ord.persist();
					p.persist();
				}
				return new ResponseEntity<String>("page1/buypromotion",HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("page1/buypromotion",HttpStatus.FOUND);
			}
	    }
		//getSessioName
		public String getSessionName(HttpServletRequest request){
			String ses = request.getUserPrincipal().toString();
			int indexS = ses.indexOf("Username:")+10;
			int indexE = ses.indexOf("Password:")-2;
			String uname = ses.substring(indexS, indexE);
			return uname;
		}
		
}
