package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.Phong;

public interface PhongService {
	public List<Phong> getAllPhong();
	public Phong getPhongById(String id);
	public void addOrUpdatePhong(Phong phong);
	public String autoId();
	

}
