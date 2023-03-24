package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kltn.api.entity.NganhHoc;

//@RepositoryRestResource(path = "nganh")
public interface NganhRepository extends JpaRepository<NganhHoc, String>{
	@Query("SELECT COUNT(*) val_count FROM NganhHoc")
	public int autoId();
	
	 
}


