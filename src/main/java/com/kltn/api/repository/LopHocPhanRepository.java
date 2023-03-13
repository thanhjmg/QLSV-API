package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.LopHocPhan;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, String>{
	@Query("SELECT COUNT(*) val_count FROM LopHocPhan")
	public int autoId();
}
