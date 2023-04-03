package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.DayNha;
import com.kltn.api.entity.Khoa;

public interface DayNhaRepository extends JpaRepository<DayNha, String>{
	@Query("SELECT COUNT(*) val_count FROM DayNha")
	public int autoId();
	
	@Query("SELECT dn FROM DayNha dn WHERE lower(dn.tenDayNha) LIKE lower(concat('%', :textSearch, '%')) "
            + "OR lower(dn.maDayNha) LIKE lower(concat('%', :textSearch, '%'))")
  public List<DayNha> timKiemDayNha(@Param("textSearch") String textSearch);
}
