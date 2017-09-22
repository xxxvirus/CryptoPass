package org.cryptopass.service.impl;

import org.cryptopass.dao.KeyAESDao;
import org.cryptopass.entity.KeyAES;
import org.cryptopass.service.KeyAESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyAESServiceImpl implements KeyAESService {

	@Autowired
	private KeyAESDao aesDao;
	
	@Override
	public KeyAES findOne(int id) {
		return aesDao.findOne(id);
	}

	@Override
	public void save(KeyAES keyAes) {
		aesDao.save(keyAes);
	}

	@Override
	public void delete(int id) {
		aesDao.delete(id);
	}

}
