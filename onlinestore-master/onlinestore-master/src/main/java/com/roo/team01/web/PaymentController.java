package com.roo.team01.web;
import com.roo.team01.domain.Payment;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payments")
@Controller
@RooWebScaffold(path = "payments", formBackingObject = Payment.class)
public class PaymentController {
}
