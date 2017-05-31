package com.roo.team01.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.Product;
import com.roo.team01.domain.Stock_bill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


 
@RequestMapping("/stock")
@Controller
public class StockController {

	@RequestMapping(value = "/all", produces = "text/html")
    public String viewall(Model uiModel) {
     	List<Stock_bill> listOrder = Stock_bill.findAllStock_bills();
     	uiModel.addAttribute("listOrder",listOrder);
        return "stock/all";
    }
	
	@RequestMapping(value = "/add", produces = "text/html")
    public String viewadd(Model uiModel) {
		List<Stock_bill> listOrder = Stock_bill.findAllStock_bills();
     	uiModel.addAttribute("listOrder",listOrder);
        //return "purchase/all";
        return "stock/add";
    }
	
	@RequestMapping(value = "/edit", produces = "text/html")
    public String viewedit(Model uiModel) {
		List<Stock_bill> listOrder = Stock_bill.findAllStock_bills();
     	uiModel.addAttribute("listOrder",listOrder);
        return "stock/edit";
    }
	
	@RequestMapping(value = "/createStock",method = RequestMethod.POST,produces = "text/html")
    public String createPurchase(@Valid Stock_bill stockOrder, HttpServletRequest httpServletReques){
		Stock_bill ct = new Stock_bill();
	 
        ct.setProduct_name(stockOrder.getProduct_name());
        ct.setProduct_num(stockOrder.getProduct_num());
        ct.setAllproduct_price(stockOrder.getAllproduct_price());
        
        if(stockOrder.getStatus()!=null){
        	ct.setStatus(stockOrder.getStatus());
        Product p = new Product();
        p.setName(stockOrder.getProduct_name());
        p.setAmount(stockOrder.getProduct_num());
        p.setProStatus(false);
        float price = Float.valueOf(stockOrder.getAllproduct_price())/stockOrder.getProduct_num();
        p.setPrice(price);
        p.persist();
        }else{
        	ct.setStatus(false);
        }
        ct.setDate_pro(stockOrder.getDate_pro());
        
        ct.persist();   
        return "stock/add";
    }
	
	@RequestMapping(value = "/changeStock",method = RequestMethod.GET,produces = "text/html")
	 public String deleteCustomer(Model uiModel, @RequestParam(value = "idOrder", required = false) String idOrder){
	        System.out.println(Stock_bill.findStock_bill(Long.valueOf(idOrder)));
	        Stock_bill po = Stock_bill.findStock_bill(Long.valueOf(idOrder));
	        po.setStatus(true);
	        Product p = new Product();
	        p.setName(po.getProduct_name());
	        p.setAmount(po.getProduct_num());
	        p.setProStatus(false);
	        float price = Float.valueOf(po.getAllproduct_price())/po.getProduct_num();
	        p.setPrice(price);
	        p.persist();
	        po.persist();
	        return "purchase/edit";
	 }
	 
	@RequestMapping(value = "/deleteStock",method = RequestMethod.GET,produces = "text/html")
	 public String deleteCustomer1(Model uiModel, @RequestParam(value = "idOrder", required = false) String idOrder){
		    
		Stock_bill or = Stock_bill.findStock_bill(Long.valueOf(idOrder));
		//Ordered or = Ordered.findOrdered(Long.valueOf(idOrder));
	        or.remove();
	        
	        return "purchase/edit";
	 }
	
}
