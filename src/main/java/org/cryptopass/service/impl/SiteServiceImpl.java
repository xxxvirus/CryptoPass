package org.cryptopass.service.impl;

import java.util.List;

import org.cryptopass.dao.SiteDao;
import org.cryptopass.entity.SIte;
import org.cryptopass.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;

	@Override
	public void save(SIte site) {
		siteDao.save(site);
	}

	@Override
	public SIte findOne(int id) {
		return siteDao.findOne(id);
	}

	@Override
	public List<SIte> findAll() {
		return siteDao.findAll();
	}

	@Override
	public void delete(int id) {
		siteDao.delete(id);
	}

	@Override
	public List<SIte> findByUserId(int id) {
		return siteDao.findByUserId(id);
	}
}
