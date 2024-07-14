package org.lessons.pizzeria.controller;

import java.util.List;

import org.lessons.pizzeria.model.Ingrediente;
import org.lessons.pizzeria.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@GetMapping
	public String index(Model model) {
	    		
	    		model.addAttribute("list", ingredienteRepository.findAll());
	    		
	    		model.addAttribute("ingrediente", new Ingrediente());
	    		
	        return "/ingredienti/index";
	    }
		

	@PostMapping("create")
	public String store(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, 
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("list", ingredienteRepository.findAll());
    		
    		model.addAttribute("ingrediente", new Ingrediente());
    		
			return "ingredienti/index";
		}
		
		ingredienteRepository.save(ingrediente);
		
		return "redirect:/ingredienti";
	}
	
	
}
