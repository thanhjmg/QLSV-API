package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, String>{
	 @Query(value = "SELECT top(1) ma_nhan_vien  FROM nhan_vien ORDER BY ma_nhan_vien DESC ", nativeQuery = true)
	 public String findTopByOrderBymaNhanVienDesc();
	  
	 @Query("SELECT n FROM NhanVien n WHERE lower(n.tenNhanVien) LIKE lower(concat('%', :textSearch, '%')) "
	            + "OR lower(n.soCCCD) LIKE lower(concat('%', :textSearch, '%')) " + "OR lower(n.maNhanVien) LIKE lower(concat('%', :textSearch, '%'))")
	  public List<NhanVien> timKiemNhanVien(@Param("textSearch") String textSearch);
}

