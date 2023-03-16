package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kltn.api.entity.ChiTietHocKy;
import com.kltn.api.entity.ChiTietHocPhan;

public interface ChiTietMonHocRepository extends JpaRepository<ChiTietHocPhan, String>{


}
