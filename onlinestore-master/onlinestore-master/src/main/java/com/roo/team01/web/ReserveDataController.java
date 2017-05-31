package com.roo.team01.web;
import com.roo.team01.domain.ReserveData;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservedatas")
@Controller
@RooWebScaffold(path = "reservedatas", formBackingObject = ReserveData.class)
public class ReserveDataController {
}
