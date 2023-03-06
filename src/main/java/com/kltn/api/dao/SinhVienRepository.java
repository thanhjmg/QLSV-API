package com.kltn.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
	 @Query(value = "SELECT top(1) ma_sinh_vien  FROM sinh_vien ORDER BY ma_sinh_vien DESC ", nativeQuery = true)
	 public String findTopByOrderBymaSinhVienDesc();
}
