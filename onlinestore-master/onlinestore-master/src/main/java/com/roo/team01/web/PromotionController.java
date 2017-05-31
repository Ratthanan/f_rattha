package com.roo.team01.web;
import com.roo.team01.domain.Promotion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/promotions")
@Controller
@RooWebScaffold(path = "promotions", formBackingObject = Promotion.class)
public class PromotionController {
}
