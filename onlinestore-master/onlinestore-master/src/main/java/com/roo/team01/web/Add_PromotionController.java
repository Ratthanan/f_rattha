package com.roo.team01.web;
import com.roo.team01.domain.Add_Promotion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/add_promotions")
@Controller
@RooWebScaffold(path = "add_promotions", formBackingObject = Add_Promotion.class)
public class Add_PromotionController {
}
