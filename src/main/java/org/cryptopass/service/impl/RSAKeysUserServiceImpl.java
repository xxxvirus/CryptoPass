package org.cryptopass.service.impl;

import org.cryptopass.dao.RSAKeysUserDao;
import org.cryptopass.entity.RSAKeysUser;
import org.cryptopass.service.RSAKeysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RSAKeysUserServiceImpl implements RSAKeysUserService {

	@Autowired
	private RSAKeysUserDao keysDao;
	
	@Override
	public RSAKeysUser findOne(int id) {
		return keysDao.findOne(id);
	}

	@Override
	public void save(RSAKeysUser key) {
		keysDao.save(key);
	}

}
