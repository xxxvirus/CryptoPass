package org.cryptopass.dao;

import org.cryptopass.entity.RSAKeysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSAKeysUserDao extends JpaRepository<RSAKeysUser, Integer> {

}
