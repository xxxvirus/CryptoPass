package org.cryptopass.dao;

import java.util.List;

import org.cryptopass.entity.SIte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SiteDao extends JpaRepository<SIte, Integer> {

	@Query("select s from SIte s where s.user.id=?1 ORDER BY s.id DESC")
	List<SIte> findByUserId(int id);
}
