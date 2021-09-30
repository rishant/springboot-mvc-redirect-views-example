package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("sample")
public class SampleApiController {
	
	//RedirectView
	@GetMapping("/redirectWithRedirectPrefix")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
		System.out.println("Redirecting.....");
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/sampleOrder/orderResponse", model);
    }
	
	//InternalResourceView
    @GetMapping("/forwardWithForwardPrefix")
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
    	System.out.println("Forwording.....");
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/sampleOrder/orderResponse", model);
    }
    
    @GetMapping("/redirectWithRedirectAttributes")
    public RedirectView redirectWithRedirectAttributes(RedirectAttributes attributes) {
    	System.out.println("Redirecting using redirectview.....");     
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new RedirectView("/sampleOrder/redirectedUrl");
    }
    
    @RequestMapping(value="/forwardWithParams", method = RequestMethod.GET)
    public ModelAndView forwardWithParams(HttpServletRequest request) {
        request.setAttribute("param1", "one");
        request.setAttribute("param2", "two");
        return new ModelAndView("forward:/forwardedWithParams");
    }
}
