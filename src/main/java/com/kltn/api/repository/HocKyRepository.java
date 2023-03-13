package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.HocKy;

public interface HocKyRepository extends JpaRepository<HocKy, String>{
	@Query("SELECT COUNT(*) val_count FROM HocKy")
	public int autoId();
}
