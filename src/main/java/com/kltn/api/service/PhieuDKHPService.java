package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.ChiTietPhieuDangKy;
import com.kltn.api.entity.PhieuDangKyHocPhan;

public interface PhieuDKHPService {
	public List<PhieuDangKyHocPhan> getAllPhieuDKHP();
	public PhieuDangKyHocPhan getPhieuDKHPById(String id);
	public void addOrUpdatePhieuDK(PhieuDangKyHocPhan phieuDangKyHocPhan);
	public String autoId();
	public void addChiTietPhieuDKHP(ChiTietPhieuDangKy chiTietPhieuDangKy);
}
