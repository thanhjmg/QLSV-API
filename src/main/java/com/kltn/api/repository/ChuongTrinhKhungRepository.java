package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChuongTrinhKhung;
import com.kltn.api.entity.MonHoc;

public interface ChuongTrinhKhungRepository extends JpaRepository<ChuongTrinhKhung, String>{
	@Query("SELECT COUNT(*) val_count FROM ChuongTrinhKhung")
	public int autoId();
	
	@Query("SELECT ctk FROM ChuongTrinhKhung ctk WHERE lower(ctk.nganhHoc.tenNganh) LIKE lower(concat('%', :valueSearch, '%')) "
			+"OR lower(ctk.nganhHoc.maNganh) LIKE lower(concat('%', :valueSearch, '%')) "
            + "OR lower(ctk.maChuongTrinhKhung) LIKE lower(concat('%', :valueSearch, '%'))")
	public List<ChuongTrinhKhung> getCTKByTextSearch(@Param("valueSearch") String valueSearch);
	
	
}
