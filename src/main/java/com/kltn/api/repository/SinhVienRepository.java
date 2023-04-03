package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.NhanVien;
import com.kltn.api.entity.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
	 @Query(value = "SELECT top(1) ma_sinh_vien  FROM sinh_vien ORDER BY ma_sinh_vien DESC ", nativeQuery = true)
	 public String findTopByOrderBymaSinhVienDesc();
	 
	 @Query("SELECT COUNT(sv.maSinhVien) FROM SinhVien sv WHERE sv.lopHoc LIKE CONCAT('%', :classID, '%')")
	  public  Long countStudentsByClass(@Param("classID") String classID);
	 
	 @Query("SELECT sv FROM SinhVien sv WHERE lower(sv.tenSinhVien) LIKE lower(concat('%', :textSearch, '%')) "
	            + "OR lower(sv.soCCCD) LIKE lower(concat('%', :textSearch, '%')) " + "OR lower(sv.maSinhVien) LIKE lower(concat('%', :textSearch, '%'))")
	  public List<SinhVien> timKiemSinhVien(@Param("textSearch") String textSearch);
}
