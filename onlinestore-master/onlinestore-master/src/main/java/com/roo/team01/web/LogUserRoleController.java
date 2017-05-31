package com.roo.team01.web;
import com.roo.team01.domain.LogUserRole;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/loguserroles")
@Controller
@RooWebScaffold(path = "loguserroles", formBackingObject = LogUserRole.class)
public class LogUserRoleController {
}
