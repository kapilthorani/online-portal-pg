package net.nkt.onlineportalpgbackend.dao;

import java.util.List;

import net.nkt.onlineportalpgbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
}
