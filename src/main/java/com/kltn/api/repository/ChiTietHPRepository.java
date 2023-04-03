package com.kltn.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChiTietHocPhan;

public interface ChiTietHPRepository extends JpaRepository<ChiTietHocPhan, String>{
//	@Query("SELECT cthp FROM ChiTietHocPhan cthp JOIN cthp.hocKy hk\r\n"
//			+ "WHERE hk.thoiGianKT BETWEEN :startDate AND :endDate\r\n"
//			+ "ORDER BY hk.thoiGianKT ASC")
	@Query(value = "SELECT DISTINCT chi_tiet_hoc_phan.*, hoc_ky.thoi_giankt\r\n"
			+ "FROM     chi_tiet_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_ky ON chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky INNER JOIN\r\n"
			+ "                  hoc_phan ON chi_tiet_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan CROSS JOIN\r\n"
			+ "                  chuong_trinh_khung\r\n"
			+ "				  WHERE hoc_ky.thoi_giankt BETWEEN :startDate AND :endDate and chi_tiet_hoc_phan.ma_chuong_trinh_khung like :maCTK\r\n"
			+ "			ORDER BY hoc_ky.thoi_giankt ASC", nativeQuery = true)
	public List<ChiTietHocPhan> getChiTietHocPhanTheoKhoaHoc(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("maCTK") String maCTK);
}
