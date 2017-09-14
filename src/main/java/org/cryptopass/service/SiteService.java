package org.cryptopass.service;

import java.util.List;

import org.cryptopass.entity.SIte;

public interface SiteService {

	void save(SIte site);
	SIte findOne(int id);
	List<SIte> findAll();
	void delete(int id);
	
	List<SIte> findByUserId(int id);
}
