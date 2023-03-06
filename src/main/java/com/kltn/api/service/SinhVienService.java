package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.SinhVien;

public interface SinhVienService {
	public void saveOrUpdateSinhVien(SinhVien sinhVien );
	public List<SinhVien> getAllSinhVien();
	public SinhVien getNganhHocById(String id);
	public String autoId();
}
