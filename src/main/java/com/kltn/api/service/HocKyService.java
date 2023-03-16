package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.ChiTietHocKy;
import com.kltn.api.entity.ChiTietHocPhan;
import com.kltn.api.entity.HocKy;

public interface HocKyService {
	public List<HocKy> getAllKhoa();
	public HocKy getHocKyById(String id);
	public void addOrUpdateHocKy(HocKy hocKy);
	public String autoId();
	public void addChiTietMonHoc(ChiTietHocPhan chiTietMonHoc);
}
