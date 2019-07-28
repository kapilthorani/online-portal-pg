package net.nkt.onlineportalpgbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.nkt.onlineportalpgbackend.dao.PGDAO;
import net.nkt.onlineportalpgbackend.dto.PG;

public class PGTestCase {

	private static AnnotationConfigApplicationContext context;

	private static PGDAO pgDAO;

	private PG pg;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.nkt.onlineportalpgbackend");
		context.refresh();
		pgDAO = (PGDAO) context.getBean("pgDAO");
	}
	
/*	@Test
	public void testCRUDPG() {
		
		//create operation
		pg = new PG();
		
		pg.setName("Paying Guests");
		pg.setAc("No");
		pg.setBed("Yes");
		pg.setGeyser("Yes");
		pg.setFridge("No");
		pg.setWashingMachine("Yes");
		pg.setAppartment("Semi-Furnished");
		pg.setBudget(6000);
		pg.setGender("Male");
		pg.setLocation("Pune Hinjawadi");
		pg.setPgtype("2BHK");
		pg.setParking("No");
		pg.setActive(true);
		pg.setCategoryId(2);
		pg.setOwnerId(2);
		
		assertEquals("Something went wrong while inserting a PG", true, pgDAO.add(pg));
		
		// reading and Updating PG
		pg = pgDAO.get(2);
		pg.setName("PKT Girls Hostel");
		assertEquals("Something went wrong while updating the existing records", true, pgDAO.update(pg));
		
		assertEquals("Something went wrong while deleting the existing records", true, pgDAO.delete(pg));
		
		assertEquals("Something went wrong while fetching the list of pgs",4 , pgDAO.list().size());
			
	}*/
	
	@Test
	public void testListActivePGs() {
		assertEquals("Something went wrong while fetching the list of pgs",
				3 , pgDAO.listActivePGs().size());
		
	}
	
	@Test
	public void testListActivePGsByCategory() {
		assertEquals("Something went wrong while fetching the list of pgs",
				1 , pgDAO.listActivePGsByCategory(2).size());
		assertEquals("Something went wrong while fetching the list of pgs",
				1 , pgDAO.listActivePGsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActivePGs() {
		assertEquals("Something went wrong while fetching the list of pgs",
				2 , pgDAO.getLatestActviePGs(2).size());
	}
}
