package net.nkt.onlineportalpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.nkt.onlineportalpgbackend.dao.PGDAO;
import net.nkt.onlineportalpgbackend.dto.PG;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	
	@Autowired
	private PGDAO pgDAO;
	
	@RequestMapping("/all/pgs")
	@ResponseBody
	public List<PG> getAllPGs() {
		return pgDAO.listActivePGs();
	}
	
	@RequestMapping("category/{id}/pgs")
	@ResponseBody
	public List<PG> getPGsByCategory(@PathVariable int id) {
		return pgDAO.listActivePGsByCategory(id);
	}
	
}
