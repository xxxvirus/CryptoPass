package org.cryptopass.service;

import java.util.List;

import org.cryptopass.entity.SIte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SiteService {

	void save(SIte site);
	SIte findOne(int id);
	List<SIte> findAll();
	void delete(int id);
	void update(SIte site);
	
	Page<SIte> findByUserId(int id, Pageable pageable);
	
	void createSite(SIte site);
	void editSite(SIte site, int idd);
}
