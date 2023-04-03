package com.kltn.api.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.Lich;

public interface LichService {
	public void saveOrUpdateLich(Lich lich);
	public List<Lich> getAllLich();
	public Lich getLichById(String id);
	public String autoId();
	public List<Lich> getTatCaLichTheoMaLHP( String maLHP);

}
