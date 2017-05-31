package com.roo.team01.web;
import com.roo.team01.domain.Total_amount;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/total_amounts")
@Controller
@RooWebScaffold(path = "total_amounts", formBackingObject = Total_amount.class)
public class Total_amountController {
}
