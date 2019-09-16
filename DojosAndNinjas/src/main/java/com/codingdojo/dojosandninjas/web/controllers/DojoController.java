package com.codingdojo.dojosandninjas.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.web.models.Dojo;
import com.codingdojo.dojosandninjas.web.models.Ninja;
import com.codingdojo.dojosandninjas.web.services.DojoNinjaService;
import com.codingdojo.dojosandninjas.web.services.DojoNinjaService;




@Controller
public class DojoController {
	private final DojoNinjaService dojoNinjaService;
	
	public DojoController(DojoNinjaService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojoObject") Dojo dojo) {
		return "/views/newdojo.jsp";
	}
	
	@PostMapping("/adddojo")
	public String addDojo(@Valid @ModelAttribute("dojoObject") Dojo dojo, BindingResult result, Object dojoNinjaService) {
		if(result.hasErrors()) {
			return "/views/newdojo.jsp";
		}
		else {
			((DojoNinjaService) dojoNinjaService).addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId") long id, Model model) {
		Dojo dojo = DojoNinjaService.singleDojo(id);
		model.addAttribute("dojo", dojo);
		return "/views/show.jsp";
	}
}