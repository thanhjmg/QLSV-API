package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, String>{
	@Query("SELECT COUNT(*) val_count FROM MonHoc")
	public int autoId();
}
