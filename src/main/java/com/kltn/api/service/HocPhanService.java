package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.HocPhan;
import com.kltn.api.entity.LopHoc;

public interface HocPhanService {
	public void saveOrUpdateHocPhan(HocPhan hocPhan);
	public List<HocPhan> getAllHocPhan();
	public HocPhan getHocPhanById(String id);
	public String autoId();
}
