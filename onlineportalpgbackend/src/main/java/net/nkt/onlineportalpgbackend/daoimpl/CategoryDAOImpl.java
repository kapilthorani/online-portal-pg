package net.nkt.onlineportalpgbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.nkt.onlineportalpgbackend.dao.CategoryDAO;
import net.nkt.onlineportalpgbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		//adding first category
		category.setId(1);
		category.setName("1BHK");
		category.setDescription("This is some Description of 1BHK");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category = new Category();
		//adding second category
		category.setId(2);
		category.setName("2BHK");
		category.setDescription("This is some Description of 2BHK");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
	    category = new Category();
		//adding Third category
		category.setId(3);
		category.setName("3BHK");
		category.setDescription("This is some Description of 3BHK");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
		}
			
		return null;
	}

}
