package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("sampleOrder")
public class SampleOrderApiController {

	@GetMapping("/orderResponse")
	public ResponseEntity<String> sampleResponse(@ModelAttribute("flashAttribute") Object flashAttribute){
		System.out.println("Redirected/Forworded api orderResponse .....");
		return ResponseEntity.ok("Hollo Sample form Sample Response");
	}
	
	@GetMapping("/redirectedUrl")
	public ModelAndView redirection(ModelMap model, @ModelAttribute("flashAttribute") Object flashAttribute) {
		System.out.println("RedirectView to ModelAndView .....");
		model.addAttribute("redirectionAttribute", flashAttribute);
		return new ModelAndView("redirection", model);
	}

	@RequestMapping(value = "/forwardedWithParams", method = RequestMethod.GET)
	public RedirectView forwardedWithParams(final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		redirectAttributes.addAttribute("param1", request.getAttribute("param1"));
		redirectAttributes.addAttribute("param2", request.getAttribute("param2"));

		redirectAttributes.addAttribute("attribute", "forwardedWithParams");
		return new RedirectView("redirectedUrl");
	}
}
