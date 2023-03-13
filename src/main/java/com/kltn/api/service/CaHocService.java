package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.CaHoc;

public interface CaHocService {

	public void saveOrUpdateCaHoc(CaHoc caHoc);
	public List<CaHoc> getAllCaHoc();
	public CaHoc getCaHocById(String id);
	public String autoId();
	}
