package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.NhanVien;

public interface NhanVienService {
	public void saveOrUpdateNhanVien(NhanVien nhanVien);
	public List<NhanVien> getAllNhanVien();
	public NhanVien getNhanVienById(String id);
	public String autoId();

}
