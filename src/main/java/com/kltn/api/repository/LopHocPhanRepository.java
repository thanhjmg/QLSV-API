package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.LopHocPhan;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, String>{
	@Query("SELECT COUNT(*) val_count FROM LopHocPhan")
	public int autoId();
	
	@Query(value = "SELECT DISTINCT lop_hoc_phan.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan\r\n"
			+ "				  where chi_tiet_hoc_phan.ma_hoc_phan like :maHP and chi_tiet_hoc_phan.ma_hoc_ky like :maHK", nativeQuery = true)
	public List<LopHocPhan> getLopHocPhanTheoMaHocPhan(@Param("maHP") String maHP, @Param("maHK") String maHK);
}
