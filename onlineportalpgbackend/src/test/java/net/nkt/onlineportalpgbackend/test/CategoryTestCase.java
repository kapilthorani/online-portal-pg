package net.nkt.onlineportalpgbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.nkt.onlineportalpgbackend.dao.CategoryDAO;
import net.nkt.onlineportalpgbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.nkt.onlineportalpgbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// Test all the CRUD Operation inside one Mehtod
	@Test
	public void testCRUDCategory() {
		//add 
		category = new Category();

		category.setName("1BHK");
		category.setDescription("This is some Description of 1BHK");
		category.setImageURL("CAT_6.png");

		assertEquals("Something went wrong while inserting a Category", true, categoryDAO.add(category));
		
		//Reading and Updating Category
		category = new Category();

		category.setName("2BHK");
		category.setDescription("This is some Description of 2BHK");
		category.setImageURL("CAT_7.png");

		assertEquals("Something went wrong while inserting a PG", true, categoryDAO.add(category));
		// fetching and updating the category
		category = categoryDAO.get(2);
		 
		category.setName("5BHK");
		assertEquals("Something went wrong while updating the existing records", true, categoryDAO.update(category));
	
		//deleting the category
		 
		assertEquals("Something went wrong while deleting the existing records", true, categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Something went wrong while fetching the list of category", 4, categoryDAO.list().size());
	}
	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("4BHK");
	 * category.setDescription("This is some Description of 4BHK");
	 * category.setImageURL("CAT_4.png");
	 * 
	 * assertEquals("Successfully added a category inside a table!", true,
	 * categoryDAO.add(category)); }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * assertEquals("Successfully fetched a single category from a table!",
	 * "1BHK", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("5BHK");
	 * assertEquals("Successfully Update a single category in the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully Delete a single category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched list all category in the table!", 1,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */

}
