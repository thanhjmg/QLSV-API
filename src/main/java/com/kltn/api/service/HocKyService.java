package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.HocKy;

public interface HocKyService {
	public List<HocKy> getAllKhoa();
	public HocKy getHocKyById(String id);
	public void addOrUpdateHocKy(HocKy hocKy);
	public String autoId();
}
