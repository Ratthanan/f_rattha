package com.roo.team01.web;
import com.roo.team01.domain.Ordered;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ordereds")
@Controller
@RooWebScaffold(path = "ordereds", formBackingObject = Ordered.class)
public class OrderedController {
}
