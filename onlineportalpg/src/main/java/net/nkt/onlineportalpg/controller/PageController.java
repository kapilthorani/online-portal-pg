package net.nkt.onlineportalpg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/admin")
	public ModelAndView admin() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admin");
		mv.addObject("userClickAdmin",true);
		return mv;
	}
	
	@RequestMapping(value = "/owner")
	public ModelAndView owner() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Owner");
		mv.addObject("userClickOwner",true);
		return mv;
	}
	
	@RequestMapping(value = "/tenant")
	public ModelAndView tenant() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Tenant");
		mv.addObject("userClickTenant",true);
		return mv;
	}
	
	@RequestMapping(value = "/searchpg")
	public ModelAndView searchpg() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Search PG");
		mv.addObject("userClickSearchPG",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/services")
	public ModelAndView services() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Services");
		mv.addObject("userClickServices",true);
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		return mv;
	}*/
	

	/*@RequestMapping(value = { "/test" })
	// public ModelAndView test(@RequestParam("greeting")String
	// greeting){//mandatory greeting
	public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) {

		if (greeting == null) {
			greeting = "Hello, there";
		}

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	/*
	@RequestMapping(value = { "/test/{greeting}" })
	public ModelAndView test(@PathVariable("greeting") String greeting) {

		if (greeting == null) {
			greeting = "Hello, there";
		}

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
}
