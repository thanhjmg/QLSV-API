package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.Phong;

public interface PhongRepository extends JpaRepository<Phong, String> {
	@Query("SELECT COUNT(*) val_count FROM Phong")
	public int autoId();

}
