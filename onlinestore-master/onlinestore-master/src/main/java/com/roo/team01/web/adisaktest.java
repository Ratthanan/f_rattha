package com.roo.team01.web;

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

import com.roo.team01.domain.Comment;
import com.roo.team01.domain.Ordered;
import com.roo.team01.domain.Payment;
import com.roo.team01.domain.Post;
import com.roo.team01.domain.Product;

@RequestMapping("/adisak")
@Controller

public class adisaktest {
	@RequestMapping(value = "/payment", produces = "text/html")
    public String viewProductadd(Model uiModel){
		
		return "adisak/payment";
    }
	@RequestMapping(value = "/paymentadmin", produces = "text/html")
    public String viewProductadmin(Model uiModel){
		List<Payment> listpayment = Payment.findAllPayments();
		uiModel.addAttribute("listpayment", listpayment);
		return "adisak/paymentadmin";
		
    }
	@RequestMapping(value = "/post", produces = "text/html")
    public String viewPost(Model uiModel){
		List<Post> listpost = Post.findAllPosts();
		List<Comment> listcomment = Comment.findAllComments();
		uiModel.addAttribute("listpost", listpost);
		uiModel.addAttribute("listcomment", listcomment);
		return "adisak/post";
    }
	@RequestMapping(value = "/createPay",method = RequestMethod.POST ,produces = "text/html")
    public String createPayment(@Valid Payment pay,Model uiModel,HttpServletRequest request){
		
		
			Payment p = new Payment();
			Ordered o = Ordered.findOrdered(pay.getOrdered().getId());
			o.getProducts().setAmount(o.getProducts().getAmount()-o.getNum());
			p.setOrdered(o);
			p.setAmount(pay.getAmount());
			p.setStatus(false);
			p.setDates(pay.getDates());
			p.setAccount(pay.getAccount());
			p.setTimes(request.getParameter("timehr")+":"+request.getParameter("times"));
			o.setStatus(true);
			o.setWarringStatus(false);
			o.persist();
			p.persist();
			
		
			return "adisak/payment";
		
    }
	@RequestMapping(value = "/createPost",method = RequestMethod.GET ,produces = "text/html")
    public String createpost(Model uiModel,@RequestParam(value = "posttext", required = false) String posttext,HttpServletRequest request){
		System.out.println(posttext);
		String users = getSessionName(request);
		Post post = new Post();
		post.setText(posttext);
		post.setUsers(users);
		post.persist();
	
			return "adisak/post";
		
    }
	
	@RequestMapping(value = "/checkPayment",method = RequestMethod.GET,produces = "text/html")
    public String checkPayment(Model uiModel, @RequestParam(value = "idPayment", required = false) String idPayment){
		Payment pay = Payment.findPayment(Long.valueOf(idPayment));
		Ordered o = Ordered.findOrdered(pay.getOrdered().getId());
		o.setStatus(true);
		o.setWarringStatus(false);
		pay.setStatus(true);
		pay.persist();
		o.persist();
        return "adisak/paymentadmin";
    }
	@RequestMapping(value = "/warningPayment",method = RequestMethod.GET,produces = "text/html")
    public String warningPayment(Model uiModel, @RequestParam(value = "idPayment", required = false) String idPayment){
		Payment pay = Payment.findPayment(Long.valueOf(idPayment));
		Ordered o = Ordered.findOrdered(pay.getOrdered().getId());
		o.setWarringStatus(true);
		o.setStatus(false);
		o.persist();
		pay.remove();
        return "adisak/paymentadmin";
    }
	@RequestMapping(value = "/commentPost",method = RequestMethod.GET,produces = "text/html")
    public String deleteCustomer(HttpServletRequest request,Model uiModel, @RequestParam(value = "idPost", required = false) String idPost, @RequestParam(value = "comment", required = false) String comment){
			System.out.println(idPost + comment);
			String users = getSessionName(request);
			Comment c = new Comment();
        	Post p = Post.findPost(Long.valueOf(idPost));
        	c.setPost(p);
        	c.setText(comment);
        	c.setUsers(users);
        	c.persist();
        return "adisak/post";
    }
	public String getSessionName(HttpServletRequest request){
		String ses = request.getUserPrincipal().toString();
		int indexS = ses.indexOf("Username:")+10;
		int indexE = ses.indexOf("Password:")-2;
		String uname = ses.substring(indexS, indexE);
		return uname;
	}

}
