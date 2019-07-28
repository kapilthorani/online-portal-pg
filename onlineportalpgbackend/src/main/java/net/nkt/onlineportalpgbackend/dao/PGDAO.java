package net.nkt.onlineportalpgbackend.dao;

import java.util.List;

import net.nkt.onlineportalpgbackend.dto.PG;

public interface PGDAO {
	
	PG get(int pgId);
	List<PG> list();
	boolean add(PG pg);
	boolean update(PG pg);
	boolean delete(PG pg);
	
	// bussiness methods
	List<PG> listActivePGs();
	List<PG> listActivePGsByCategory(int categoryId);
	List<PG> getLatestActviePGs(int count);
}
