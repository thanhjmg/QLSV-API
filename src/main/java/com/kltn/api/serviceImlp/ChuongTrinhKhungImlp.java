package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.ChiTietHocKyRepository;
import com.kltn.api.dao.ChuongTrinhKhungRepository;
import com.kltn.api.entity.ChiTietHocKy;
import com.kltn.api.entity.ChuongTrinhKhung;
import com.kltn.api.service.ChuongTrinhKhungService;

@Service
@Transactional
public class ChuongTrinhKhungImlp implements ChuongTrinhKhungService{
	
	@Autowired
	private ChuongTrinhKhungRepository chuongTrinhKhungRepository;
	private ChiTietHocKyRepository chiTietHocKyRepository;

	@Override
	public List<ChuongTrinhKhung> getAllChuongTrinhKhung() {
		// TODO Auto-generated method stub
		return chuongTrinhKhungRepository.findAll();
	}

	@Override
	public ChuongTrinhKhung getChuongTrinhKhungById(String id) {
		// TODO Auto-generated method stub
		return chuongTrinhKhungRepository.findById(id).get();
	}

	@Override
	public void addOrUpdateChuongTrinhKhung(ChuongTrinhKhung chuongTrinhKhung) {
		// TODO Auto-generated method stub
		chuongTrinhKhungRepository.save(chuongTrinhKhung);
	}

	@Override
	public String autoId() {
		int id = chuongTrinhKhungRepository.autoId();
		String naturalId = "CTK" + String.format("%03d", id+1);
		return naturalId;
	}

	@Override
	public void addChuongTrinhKhungChoHK(ChiTietHocKy chiTietHocKy) {
		chiTietHocKyRepository.save(chiTietHocKy);
		
	}

}
