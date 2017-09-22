package org.cryptopass.dao;

import org.cryptopass.entity.SIte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SiteDao extends JpaRepository<SIte, Integer> {

	@Query("select s from SIte s where s.user.id=:id")
	Page<SIte> findByUserId(@Param("id") int id, Pageable pageable);
}
