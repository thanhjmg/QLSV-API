package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChiTietPhieuDangKy;

public interface ChiTietPhieuDKHPRepository extends JpaRepository<ChiTietPhieuDangKy, String>{
	@Query(value = "SELECT chi_tiet_phieu_dang_ky.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON lop_hoc_phan.ma_lop_hoc_phan = nhom_thuc_hanh.ma_lop_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_phieu_dang_ky ON nhom_thuc_hanh.ma_nhom = chi_tiet_phieu_dang_ky.ma_nhomth\r\n"
			+ "				  where lop_hoc_phan.ma_lop_hoc_phan like :maLHP and chi_tiet_phieu_dang_ky.ma_nhomth like :maNhom", nativeQuery = true)
	public List<ChiTietPhieuDangKy> getListChiTietPDKByMaLHP(@Param("maLHP") String maLHP, @Param("maNhom") String maNhom);
	
}
