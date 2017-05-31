package com.roo.team01.web;
import com.roo.team01.domain.Product_stock;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product_stocks")
@Controller
@RooWebScaffold(path = "product_stocks", formBackingObject = Product_stock.class)
public class Product_stockController {
}
