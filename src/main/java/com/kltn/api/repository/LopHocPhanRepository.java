package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.LopHocPhan;
import com.kltn.api.entity.MonHoc;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, String>{
	@Query("SELECT COUNT(*) val_count FROM LopHocPhan")
	public int autoId();
	
	@Query(value = "SELECT DISTINCT lop_hoc_phan.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan\r\n"
			+ "				  where chi_tiet_hoc_phan.ma_hoc_phan like :maHP and chi_tiet_hoc_phan.ma_hoc_ky like :maHK", nativeQuery = true)
	public List<LopHocPhan> getLopHocPhanTheoMaHocPhan(@Param("maHP") String maHP, @Param("maHK") String maHK);
	

	
	@Query(value = "SELECT DISTINCT lop_hoc_phan.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan\r\n"
			+ "				  where chi_tiet_hoc_phan.ma_hoc_phan like :maHP", nativeQuery = true)
	public List<LopHocPhan> getLopHocPhanTheoMaHP(@Param("maHP") String maHP);

	@Query(value = "SELECT DISTINCT lop_hoc_phan.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON lop_hoc_phan.ma_lop_hoc_phan = nhom_thuc_hanh.ma_lop_hoc_phan INNER JOIN\r\n"
			+ "                  lich ON lop_hoc_phan.ma_lop_hoc_phan = lich.ma_lop_hoc_phan AND nhom_thuc_hanh.ma_nhom = lich.ma_nhomth INNER JOIN\r\n"
			+ "                  nhan_vien ON lich.id_nhan_vien = nhan_vien.ma_nhan_vien INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_ky ON chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky\r\n"
			+ "				  where nhan_vien.ma_nhan_vien like :maGV and hoc_ky.ma_hoc_ky like :maHK and hoc_phan.ma_hoc_phan like :maHP", nativeQuery = true)
	public List<LopHocPhan> getTatCaLHPByHocPhanAndMaGVAndMaHK(@Param("maGV") String maGV, @Param("maHK") String maHK, @Param("maHP") String maHP);
	
	@Query("SELECT lhp FROM LopHocPhan lhp WHERE lower(lhp.tenLopHocPhan) LIKE lower(concat('%', :valueSearch, '%')) "
            + "OR lower(lhp.maLopHocPhan) LIKE lower(concat('%', :valueSearch, '%'))")
	public List<LopHocPhan> getLopHocPhanByTextSearch(@Param("valueSearch") String valueSearch);
}
