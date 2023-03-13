package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.CaHoc;

public interface CaHocRepository extends JpaRepository<CaHoc, String>{
	@Query("SELECT COUNT(*) val_count FROM CaHoc")
	public int autoId();
}
