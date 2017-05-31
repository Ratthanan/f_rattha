package com.roo.team01.web;
import com.roo.team01.domain.PreOrder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/preorders")
@Controller
@RooWebScaffold(path = "preorders", formBackingObject = PreOrder.class)
public class PreOrderController {
}
