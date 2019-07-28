package net.nkt.onlineportalpg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.nkt.onlineportalpg.exception.PGNotFoundException;
import net.nkt.onlineportalpgbackend.dao.CategoryDAO;
import net.nkt.onlineportalpgbackend.dao.PGDAO;
import net.nkt.onlineportalpgbackend.dto.Category;
import net.nkt.onlineportalpgbackend.dto.PG;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PGDAO pgDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
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
	/*
	 * Methods to Load all the PG based on category
	 */
	@RequestMapping(value = "/show/all/pg")
	public ModelAndView showAllPG() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All PG");
		mv.addObject("userClickAllPG",true);
		return mv;
	}
	@RequestMapping(value = "/show/category/{id}/pg")
	public ModelAndView showCategoryPG(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// categoryDAO to fetch single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		//passing the single category object
		mv.addObject("category",category);
		mv.addObject("userClickCategoryPG",true);
		return mv;
	}
	/*
	 * Viewing single product
	 * */
	@RequestMapping(value ="/show/{id}/pg")
	public ModelAndView showSinglePG(@PathVariable int id) throws PGNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		PG pg = pgDAO.get(id);
		
		if(pg == null ) throw new PGNotFoundException();
		
		//update the view count
		pg.setViews(pg.getViews() +1);
		pgDAO.update(pg);
		//-------------------------
		mv.addObject("title",pg.getName());
		mv.addObject("pg",pg);
		
		mv.addObject("userClickShowPG",true);
		
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
