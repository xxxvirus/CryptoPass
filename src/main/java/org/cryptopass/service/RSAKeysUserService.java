package org.cryptopass.service;

import org.cryptopass.entity.RSAKeysUser;

public interface RSAKeysUserService {

	RSAKeysUser findOne(int id);
	void save(RSAKeysUser key);
}
