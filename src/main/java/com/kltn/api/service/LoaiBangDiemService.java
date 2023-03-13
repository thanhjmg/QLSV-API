package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.LoaiBangDiem;

public interface LoaiBangDiemService {
	public void saveOrUpdateLoaiBangDiem(LoaiBangDiem loaiBangDiem);
	public List<LoaiBangDiem> getAllLoaiBangDiem();
	
	public String autoId();
}
