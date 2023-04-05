package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChiTietPhieuDangKy;

public interface ChiTietPhieuDKHPRepository extends JpaRepository<ChiTietPhieuDangKy, String>{
	
	 @Query(value = "SELECT chi_tiet_phieu_dang_ky.*\r\n"
	 		+ "FROM     chi_tiet_hoc_phan INNER JOIN\r\n"
	 		+ "                  hoc_ky ON chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky INNER JOIN\r\n"
	 		+ "                  hoc_phan ON chi_tiet_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
	 		+ "                  lop_hoc_phan ON hoc_phan.ma_hoc_phan = lop_hoc_phan.ma_hoc_phan INNER JOIN\r\n"
	 		+ "                  nhom_thuc_hanh ON lop_hoc_phan.ma_lop_hoc_phan = nhom_thuc_hanh.ma_lop_hoc_phan INNER JOIN\r\n"
	 		+ "                  chi_tiet_phieu_dang_ky ON nhom_thuc_hanh.ma_nhom = chi_tiet_phieu_dang_ky.ma_nhomth\r\n"
	 		+ "				  where hoc_ky.ma_hoc_ky like  :maHocKy",nativeQuery = true)
	    List<ChiTietPhieuDangKy> findByMaHocKy(@Param("maHocKy") String maHocKy);
}
