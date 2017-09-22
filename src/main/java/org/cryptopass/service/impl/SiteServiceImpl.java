package org.cryptopass.service.impl;

import java.util.List;

import org.cryptopass.crypto.AES;
import org.cryptopass.crypto.RSA;
import org.cryptopass.dao.KeyAESDao;
import org.cryptopass.dao.SiteDao;
import org.cryptopass.entity.KeyAES;
import org.cryptopass.entity.SIte;
import org.cryptopass.entity.User;
import org.cryptopass.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;
	@Autowired
	private KeyAESDao keyAESDao;
	private AES aes = new AES();

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
	public void update(SIte site) {
		siteDao.saveAndFlush(site);
	}

	@Override
	public Page<SIte> findByUserId(int id, Pageable pageable) {
		return siteDao.findByUserId(id, pageable);
	}

	@Override
	public void createSite(SIte site) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		KeyAES aesK = new KeyAES();
	    String key = aes.keyGenerator();
	    aesK.setGenKey(RSA.encrypt(key, user.getKeys().getPublickKey()));
	    keyAESDao.save(aesK);
	    site.setUser(user);
	    site.setPass(aes.encrypt(key, site.getPass()));
	    site.setKeyAES(aesK);
	    siteDao.save(site);
	}

	@Override
	public void editSite(SIte site, int idd) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		SIte site2 = siteDao.findOne(idd);
		site2.setLoginOnS(site.getLoginOnS());
		site2.setNameOfS(site.getNameOfS());
		KeyAES aesK = site2.getKeyAES();
		String key = aes.keyGenerator();
		aesK.setGenKey(RSA.encrypt(key, user.getKeys().getPublickKey()));
	    keyAESDao.saveAndFlush(aesK);
		site2.setPass(aes.encrypt(key, site.getPass()));
//		site.setUser(site2.getUser());
//		site.setKeyAES(site2.getKeyAES());
		siteDao.saveAndFlush(site2);
	}

	
}
