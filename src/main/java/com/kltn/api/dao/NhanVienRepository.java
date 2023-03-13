package com.kltn.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, String>{
	 @Query(value = "SELECT top(1) ma_nhan_vien  FROM nhan_vien ORDER BY ma_nhan_vien DESC ", nativeQuery = true)
	 public String findTopByOrderBymaNhanVienDesc();
}
