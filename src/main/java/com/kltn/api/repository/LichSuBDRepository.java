package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.LichSuBangDiem;

public interface LichSuBDRepository extends JpaRepository<LichSuBangDiem, String>{
	@Query("SELECT COUNT(*) val_count FROM LichSuBangDiem")
	public int autoId();
}
