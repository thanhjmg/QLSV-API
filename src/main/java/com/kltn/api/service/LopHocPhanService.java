package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.LopHocPhan;

public interface LopHocPhanService {
	public void saveOrUpdate(LopHocPhan lopHocPhan);
	public List<LopHocPhan> getAllLopHocPhan();
	public LopHocPhan getLopHocPhanById(String id);
	public String autoId();
	
}
