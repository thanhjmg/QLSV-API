package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.Lich;
import com.kltn.api.entity.LichSuBangDiem;

public interface LichSuBDService {
	public void saveOrUpdateLichSuBD(LichSuBangDiem lichSuBangDiem);
	public List<LichSuBangDiem> getAllLichSu();
	public String autoId();
}
