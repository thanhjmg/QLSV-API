package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.BangDiem;

public interface BangDiemRepository extends JpaRepository<BangDiem, String>{
	@Query(value = "SELECT distinct bang_diem.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  bang_diem ON hoc_phan.ma_hoc_phan = bang_diem.ma_hoc_phan\r\n"
			+ "				  where lop_hoc_phan.ma_lop_hoc_phan like :maLHP", nativeQuery = true)
	public List<BangDiem> getbangDiemTheoLHP(@Param("maLHP") String maLHP);
}
