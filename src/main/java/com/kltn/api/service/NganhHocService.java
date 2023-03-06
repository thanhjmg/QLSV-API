package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.NganhHoc;

public interface NganhHocService {
	public void saveOrUpdateNganhHoc(NganhHoc nganhHoc );
	public List<NganhHoc> getAllNganhHoc();
	public NganhHoc getNganhHocById(String id);
	public String autoId();
}
