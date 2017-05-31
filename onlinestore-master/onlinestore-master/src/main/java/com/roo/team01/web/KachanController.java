package com.roo.team01.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roo.team01.domain.Customer;
import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.Product;

import flexjson.JSONSerializer;

import static com.roo.team01.domain.Product.findProductsByNameLike;

@RequestMapping("/kachan")
@Controller
public class KachanController {
	
	@RequestMapping(value = "/create", produces = "text/html")
    public String viewProductadd(Model uiModel){
		List<Product> listproduct = Product.findAllProducts();
		uiModel.addAttribute("listproduct", listproduct);
		return "kachan/create";
    }
	@RequestMapping(value = "/add", produces = "text/html")
    public String viewCreateProduct(Model uiModel){
		
		return "kachan/add";
    }
	@RequestMapping(value = "/show", produces = "text/html")
    public String showOrdered(Model uiModel, HttpServletRequest request){
		List<Ordered> l = Ordered.findAllOrdereds();
		List<Ordered> listorder = new ArrayList<Ordered>();
		String user = getSessionName(request);
		
		for(Ordered a : l)
	    	if(a.getCustomer().getUserName().equals(user))
	    		listorder.add(a);
		
		uiModel.addAttribute("listorder", listorder);
		return "kachan/show";
    }
	@RequestMapping(value = "/buyProduct",method = RequestMethod.POST, produces = "text/html")
    public String createOrdered(@Valid Ordered or, Model uiModel, HttpServletRequest request){
		
				Ordered ord = new Ordered();
				Product p = Product.findProduct(or.getProducts().getId());
				float n = Float.valueOf(String.valueOf(or.getNum()));
				float price = p.getPrice()*n;
				String user = getSessionName(request);
				List<Customer> l = Customer.findAllCustomers();
				for(Customer c : l){
			    	   if(c.getUserName().equals(user))
			    		   ord.setCustomer(c);
			    }
				ord.setSendBy(or.getSendBy());
				ord.setProducts(p);
				ord.setNum(or.getNum());
				ord.setAmount(price);
				ord.setStatus(false);
				ord.persist();
				p.persist();
				return "kachan/add";
    }
	@RequestMapping(value = "/deleteOrder",method = RequestMethod.GET,produces = "text/html")
    public String deleteCustomer(Model uiModel, @RequestParam(value = "idOrder", required = false) String idOrder){
		
        Ordered or = Ordered.findOrdered(Long.valueOf(idOrder));
        or.remove();
        
        return "kachan/show";
    }
	@RequestMapping(value = "/findproduct",method = RequestMethod.GET,produces = "text/html")
    public ResponseEntity<String> findProduct(Model uiModel, @RequestParam(value = "products", required = false) String products) {
        List<Product> listproduct = findProductsByNameLike(products).getResultList();
        if(listproduct.size() == 0){
            return  new ResponseEntity<String>(new JSONSerializer().exclude("*.class").deepSerialize(Product.findAllProducts()), HttpStatus.OK);
        }else{
            return  new ResponseEntity<String>(new JSONSerializer().exclude("*.class").deepSerialize(listproduct), HttpStatus.OK);
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
