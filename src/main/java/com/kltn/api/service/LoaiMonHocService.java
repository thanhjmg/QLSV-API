package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.LoaiMonHoc;
import com.kltn.api.entity.LopHoc;

public interface LoaiMonHocService {
	public void saveOrUpdateLoaiMonHoc(LoaiMonHoc loaiMonHoc);
	public List<LoaiMonHoc> getAllLoaiMonHoc();
	public LoaiMonHoc getLoaiMonHocById(String id);
	public String autoId();
}
