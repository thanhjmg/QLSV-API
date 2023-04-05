package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kltn.api.entity.NhomThucHanh;

public interface NhomTHRepository extends JpaRepository<NhomThucHanh, String>{
	@Query("SELECT COUNT(*) val_count FROM NhomThucHanh")
	public int autoId();
}
