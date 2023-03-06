package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.LopHoc;

public interface LopHocService {
	public void saveOrUpdateLopHoc(LopHoc lopHoc);
	public List<LopHoc> getAllLopHoc();
	public LopHoc getLopHocById(String id);
	public String autoId();
}
