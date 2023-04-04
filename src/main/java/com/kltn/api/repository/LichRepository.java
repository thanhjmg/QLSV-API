package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.Lich;

public interface LichRepository extends JpaRepository<Lich, String> {
	@Query("SELECT COUNT(*) val_count FROM Lich")
	public int autoId();
	
	@Query(value = "select lich.* from lich where ma_lop_hoc_phan like :maLHP", nativeQuery = true)
	public List<Lich> getTatCaLichTheoMaLHP(@Param("maLHP") String maLHP);
	
	

}
