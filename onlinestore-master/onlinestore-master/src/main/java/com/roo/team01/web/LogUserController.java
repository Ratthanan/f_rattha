package com.roo.team01.web;
import com.roo.team01.domain.LogUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logusers")
@Controller
@RooWebScaffold(path = "logusers", formBackingObject = LogUser.class)
public class LogUserController {
}
