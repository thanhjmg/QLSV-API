package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.entity.ChiTietHocKy;
import com.kltn.api.entity.ChuongTrinhKhung;
import com.kltn.api.entity.Khoa;
import com.kltn.api.repository.ChiTietHocKyRepository;
import com.kltn.api.repository.ChuongTrinhKhungRepository;
import com.kltn.api.repository.HocKyRepository;
import com.kltn.api.service.ChuongTrinhKhungService;

@Service
@Transactional
public class ChuongTrinhKhungImlp implements ChuongTrinhKhungService{
	
	@Autowired
	private ChuongTrinhKhungRepository chuongTrinhKhungRepository;
	@Autowired
	private ChiTietHocKyRepository chiTietHocKyRepository;
	@Autowired
	private HocKyRepository hocKyRepository;

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
		if((!chiTietHocKy.getChuongTrinhKhung().getMaChuongTrinhKhung().equals(""))&& (!chiTietHocKy.getHocKy().getMaHocKy().equals(""))){
			var ctk = chuongTrinhKhungRepository.findById(chiTietHocKy.getChuongTrinhKhung().getMaChuongTrinhKhung()).get();
			var hk = hocKyRepository.findById(chiTietHocKy.getHocKy().getMaHocKy()).get();
			if(ctk != null && hk !=null) {
				chiTietHocKy.setChuongTrinhKhung(ctk);
				chiTietHocKy.setHocKy(hk);
			}
			
			
		}
		chiTietHocKyRepository.save(chiTietHocKy);
		
	}

}
