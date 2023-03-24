package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.HocPhan;

public interface HocPhanRepository extends JpaRepository<HocPhan, String>{
	@Query("SELECT COUNT(*) val_count FROM HocPhan")
	public int autoId();
}
