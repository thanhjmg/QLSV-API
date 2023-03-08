package com.kltn.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.LoaiMonHoc;

public interface LoaiMonHocRepository extends JpaRepository<LoaiMonHoc, String>{
	@Query("SELECT COUNT(*) val_count FROM LoaiMonHoc")
	 public int findTopByOrderByLoaiMonHocDesc();
}
