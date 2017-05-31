package com.roo.team01.web;
import com.roo.team01.domain.Stock_bill;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stock_bills")
@Controller
@RooWebScaffold(path = "stock_bills", formBackingObject = Stock_bill.class)
public class Stock_billController {
}
