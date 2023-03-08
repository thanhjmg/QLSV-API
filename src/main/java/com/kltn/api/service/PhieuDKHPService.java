package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.PhieuDangKyHocPhan;

public interface PhieuDKHPService {
	public List<PhieuDangKyHocPhan> getAllPhieuDKHP();
	public PhieuDangKyHocPhan getPhieuDKHPById(String id);
	public void addOrUpdateKhoa(PhieuDangKyHocPhan phieuDangKyHocPhan);
	public String autoId();
}
