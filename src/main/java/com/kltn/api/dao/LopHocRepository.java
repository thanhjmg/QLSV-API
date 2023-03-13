package com.kltn.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kltn.api.entity.LopHoc;

//@RepositoryRestResource(path = "lophoc")
public interface LopHocRepository extends JpaRepository<LopHoc, String>{
	@Query("SELECT COUNT(*) val_count FROM LopHoc")
	public int autoId();
}
