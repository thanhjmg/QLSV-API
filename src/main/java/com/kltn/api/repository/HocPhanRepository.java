package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.HocPhan;

public interface HocPhanRepository extends JpaRepository<HocPhan, String>{
	@Query("SELECT COUNT(*) val_count FROM HocPhan")
	public int autoId();
	
	@Query(value = "SELECT DISTINCT hoc_phan.*"
			+ "FROM     chi_tiet_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_ky ON chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky INNER JOIN\r\n"
			+ "                  hoc_phan ON chi_tiet_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  mon_hoc ON hoc_phan.ma_mon_hoc = mon_hoc.ma_mon_hoc\r\n"
			+ "				  where hoc_ky.ma_hoc_ky like :maHocKy ", nativeQuery = true)
	public List<HocPhan> getHocPhanTheoHocKy(@Param("maHocKy") String maHocKy);
	
	@Query(value = "SELECT hoc_phan.*\r\n"
			+ "FROM     hoc_phan INNER JOIN\r\n"
			+ "                  mon_hoc ON hoc_phan.ma_mon_hoc = mon_hoc.ma_mon_hoc\r\n"
			+ "				  where mon_hoc.ma_mon_hoc like :maMH", nativeQuery = true)
	public HocPhan getHocPhanTheoMaMH(@Param("maMH") String maMH);
}
