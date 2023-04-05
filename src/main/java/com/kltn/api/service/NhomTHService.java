package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.CaHoc;
import com.kltn.api.entity.NhomThucHanh;

public interface NhomTHService {
	public void saveOrUpdateNhomTH(NhomThucHanh nhomThucHanh);
	public List<NhomThucHanh> getAllNhomTH();
	public String autoId();
}
