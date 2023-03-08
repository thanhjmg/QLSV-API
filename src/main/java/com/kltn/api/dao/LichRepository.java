package com.kltn.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.Lich;

public interface LichRepository extends JpaRepository<Lich, String> {
	@Query("SELECT COUNT(*) val_count FROM Lich")
	public int autoId();

}
