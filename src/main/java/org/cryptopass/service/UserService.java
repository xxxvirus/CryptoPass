package org.cryptopass.service;

import org.cryptopass.entity.User;

public interface UserService {

	void save(User user);
	void update(User user);
	User findByEmail(String email);

	User findOne(int id);
	
}
