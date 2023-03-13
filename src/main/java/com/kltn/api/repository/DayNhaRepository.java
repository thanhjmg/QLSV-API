package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.DayNha;

public interface DayNhaRepository extends JpaRepository<DayNha, String>{
	@Query("SELECT COUNT(*) val_count FROM DayNha")
	public int autoId();
}
