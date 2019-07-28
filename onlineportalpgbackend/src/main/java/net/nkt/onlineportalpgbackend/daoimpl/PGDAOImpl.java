package net.nkt.onlineportalpgbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.nkt.onlineportalpgbackend.dao.PGDAO;
import net.nkt.onlineportalpgbackend.dto.PG;

@Repository("pgDAO")
@Transactional
public class PGDAOImpl implements PGDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	/*
	 * Getting a single PG based on id
	 */
	@Override
	public PG get(int pgId) {
		try {
		return sessionFactory
				.getCurrentSession()
					.get(PG.class, Integer.valueOf(pgId));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/*
	 * LIST
	 */
	@Override
	public List<PG> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM PG",PG.class)
						.getResultList();
	}
	
	/*
	 * INSERT
	 * */
	@Override
	public boolean add(PG pg) {
		try {

			// add the pg to the database Table
			sessionFactory
				.getCurrentSession()
					.persist(pg);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			
		}
		return false;
	}
	
	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(PG pg) {
		try {

			// update the pg to the database Table
			sessionFactory
				.getCurrentSession()
					.update(pg);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			
		}
		return false;
	}
	
	/*
	 * Delete a single pg
	 */
	@Override
	public boolean delete(PG pg) {
		try {
			pg.setActive(false);
			//call the update method
			return this.update(pg);
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<PG> listActivePGs() {
		String selectActivePGs = "FROM PG WHERE active = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActivePGs,PG.class)
							.setParameter("active", true)
								.getResultList();
	}

	@Override
	public List<PG> listActivePGsByCategory(int categoryId) {
		String selectActivePGsByCategory = "FROM PG WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActivePGsByCategory,PG.class)
							.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
	}

	@Override
	public List<PG> getLatestActviePGs(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM PG WHERE active = :active ORDER BY id",PG.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}
