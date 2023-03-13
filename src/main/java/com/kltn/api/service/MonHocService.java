package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.Khoa;
import com.kltn.api.entity.MonHoc;

public interface MonHocService {
	public List<MonHoc> getAllMonHoc();
	public MonHoc getMonHocById(String id);
	public void addOrUpdateMonHoc(MonHoc monHoc);
	public String autoId();
	
}
