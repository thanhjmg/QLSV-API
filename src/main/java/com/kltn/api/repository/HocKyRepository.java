package com.kltn.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.HocKy;
import com.kltn.api.entity.Khoa;

public interface HocKyRepository extends JpaRepository<HocKy, String>{
	@Query("SELECT COUNT(*) val_count FROM HocKy")
	public int autoId();
	
	 @Query("SELECT hk FROM HocKy hk WHERE lower(hk.tenHocKy) LIKE lower(concat('%', :textSearch, '%')) "
	            + "OR lower(hk.maHocKy) LIKE lower(concat('%', :textSearch, '%'))")
	  public List<HocKy> timKiemHocKy(@Param("textSearch") String textSearch);
	 
	 @Query("SELECT h FROM HocKy h WHERE h.thoiGianKT BETWEEN :startDate AND :endDate ORDER BY h.thoiGianKT ASC")
	    List<HocKy> findHocKyByThoiGianKTBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	 
	 @Query(value = "SELECT hoc_ky.*\r\n"
	 		+ "FROM     chuong_trinh_khung INNER JOIN\r\n"
	 		+ "                  chi_tiet_hoc_ky ON chuong_trinh_khung.ma_chuong_trinh_khung = chi_tiet_hoc_ky.ma_chuong_trinh_khung INNER JOIN\r\n"
	 		+ "                  hoc_ky ON chi_tiet_hoc_ky.ma_hoc_ky = hoc_ky.ma_hoc_ky\r\n"
	 		+ "				  where chuong_trinh_khung.ma_chuong_trinh_khung like :maCTK", nativeQuery = true)
	 public List<HocKy> getHocKyByMaCTK(@Param("maCTK") String maCTK);
}
