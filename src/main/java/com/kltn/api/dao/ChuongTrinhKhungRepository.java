package com.kltn.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.ChuongTrinhKhung;

public interface ChuongTrinhKhungRepository extends JpaRepository<ChuongTrinhKhung, String>{
	@Query("SELECT COUNT(*) val_count FROM ChuongTrinhKhung")
	public int autoId();
}
