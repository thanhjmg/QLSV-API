package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kltn.api.entity.Khoa;

//@RepositoryRestResource(path = "khoa")
public interface KhoaRepository extends JpaRepository<Khoa, String>{
	@Query("SELECT COUNT(*) val_count FROM Khoa")
	public int autoId();

}
