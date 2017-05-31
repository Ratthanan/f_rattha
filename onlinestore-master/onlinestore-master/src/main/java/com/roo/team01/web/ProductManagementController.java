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

import com.roo.team01.domain.Product;

@RooJavaBean
@RooToString
@RequestMapping("/pro")
@Controller
public class ProductManagementController {
	
	@RequestMapping(value = "/add", produces = "text/html")
    public String viewProductadd(Model uiModel){
		List<Product> listproduct = Product.findAllProducts();
		uiModel.addAttribute("listproduct", listproduct);
		return "pro/add";
    }
	
/*	@RequestMapping(value = "/createProduct",method = RequestMethod.POST, produces = "text/html")
    public String createUser(@Valid Product p, Model uiModel,BindingResult bindingResult, HttpServletRequest request){
			Product product = new Product();
			product.setName(p.getName());
			product.setPrice(p.getPrice());
			product.setDetail(p.getDetail());
			product.setAmount(p.getAmount());
			product.setProStatus(false);
			product.persist();
			return "pro/add";
		
    }*/
}
