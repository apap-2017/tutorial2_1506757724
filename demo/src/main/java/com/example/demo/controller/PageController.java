package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController
{
	@RequestMapping("/hello")
	public String index()
	{
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model)
	{
		if(name.isPresent())
		{
			model.addAttribute("name", name.get());
		}
		else
		{
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String multiplier(@RequestParam(value = "a", required = false, defaultValue = "0") int number1, @RequestParam(value = "b", required = false, defaultValue = "0") int number2 , Model model)
	{
		model.addAttribute("number1", number1);
		model.addAttribute("number2", number2);
		
		int hasil = number1 * number2;
		model.addAttribute("result", hasil);
		
		return "perkalian";
	}
}