package org.cryptopass.service;

import org.cryptopass.entity.KeyAES;

public interface KeyAESService {

	KeyAES findOne(int id);
	void save(KeyAES keyAes);
	void delete(int id);
}
