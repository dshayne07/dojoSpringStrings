package com.project.Strings.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	private String[] message = new String[3];
	public Router(){
		this.message[0] = "Spring Boot is great! So easy to just respond with strings!";
		this.message[1] = "Keep up the good work!";
		this.message[2] = "Here's another random message!";
	}

	@RequestMapping("random")
	public String random(Model model){
		Random rand = new Random();
		int  n = rand.nextInt(3);
		model.addAttribute("message",this.message[n]);
		return "random";
	}

	@RequestMapping("index")
	public String index(HttpSession session){
		return "index";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
