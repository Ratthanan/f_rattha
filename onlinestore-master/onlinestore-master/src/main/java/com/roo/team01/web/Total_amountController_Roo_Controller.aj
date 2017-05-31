// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.roo.team01.web;

import com.roo.team01.domain.Total_amount;
import com.roo.team01.web.Total_amountController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect Total_amountController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String Total_amountController.create(@Valid Total_amount total_amount, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, total_amount);
            return "total_amounts/create";
        }
        uiModel.asMap().clear();
        total_amount.persist();
        return "redirect:/total_amounts/" + encodeUrlPathSegment(total_amount.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String Total_amountController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Total_amount());
        return "total_amounts/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String Total_amountController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("total_amount", Total_amount.findTotal_amount(id));
        uiModel.addAttribute("itemId", id);
        return "total_amounts/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String Total_amountController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("total_amounts", Total_amount.findTotal_amountEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Total_amount.countTotal_amounts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("total_amounts", Total_amount.findAllTotal_amounts(sortFieldName, sortOrder));
        }
        return "total_amounts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String Total_amountController.update(@Valid Total_amount total_amount, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, total_amount);
            return "total_amounts/update";
        }
        uiModel.asMap().clear();
        total_amount.merge();
        return "redirect:/total_amounts/" + encodeUrlPathSegment(total_amount.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String Total_amountController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Total_amount.findTotal_amount(id));
        return "total_amounts/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String Total_amountController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Total_amount total_amount = Total_amount.findTotal_amount(id);
        total_amount.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/total_amounts";
    }
    
    void Total_amountController.populateEditForm(Model uiModel, Total_amount total_amount) {
        uiModel.addAttribute("total_amount", total_amount);
    }
    
    String Total_amountController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}