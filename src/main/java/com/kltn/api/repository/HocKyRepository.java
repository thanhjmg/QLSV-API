package com.kltn.api.repository;

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
}
