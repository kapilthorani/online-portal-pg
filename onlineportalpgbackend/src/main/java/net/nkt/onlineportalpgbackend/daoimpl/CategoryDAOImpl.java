package net.nkt.onlineportalpgbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.nkt.onlineportalpgbackend.dao.CategoryDAO;
import net.nkt.onlineportalpgbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		String selectActiveCategory ="FROM Category WHERE active =:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * Getting a single category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			// add the category to the database Table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			
		}
		return false;
	}

	/*
	 * Update a single category
	 */
	@Override
	public boolean update(Category category) {

		try {

			// update the category to the database Table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			
		}
		return false;
	}
	
	/*
	 * Delete a single category
	 */
	@Override
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			//call the update method
			return this.update(category);
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

}
