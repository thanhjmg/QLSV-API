package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.PhieuDKHPRepository;
import com.kltn.api.dao.SinhVienRepository;
import com.kltn.api.entity.Khoa;
import com.kltn.api.entity.PhieuDangKyHocPhan;
import com.kltn.api.entity.SinhVien;
import com.kltn.api.service.PhieuDKHPService;

@Service
@Transactional
public class PhieuDKHPServiceImlp implements PhieuDKHPService{
	
	@Autowired
	private PhieuDKHPRepository phieuDKHPRepository;
	@Autowired
	private SinhVienRepository sinhVienRepository;
	

	@Override
	public List<PhieuDangKyHocPhan> getAllPhieuDKHP() {
		// TODO Auto-generated method stub
		return phieuDKHPRepository.findAll();
	}

	@Override
	public PhieuDangKyHocPhan getPhieuDKHPById(String id) {
		// TODO Auto-generated method stub
		return phieuDKHPRepository.findById(id).get();
	}

	@Override
	public void addOrUpdateKhoa(PhieuDangKyHocPhan phieuDangKyHocPhan) {
		if(!phieuDangKyHocPhan.getSinhVien().getMaSinhVien().equals("")) {
			var sinhVien = sinhVienRepository.findById(phieuDangKyHocPhan.getSinhVien().getMaSinhVien()).get();
			
			if(sinhVien != null) {
				phieuDangKyHocPhan.setSinhVien(sinhVien);
			}
			else {
				sinhVien = new SinhVien(phieuDangKyHocPhan.getSinhVien().getMaSinhVien());
				phieuDangKyHocPhan.setSinhVien(sinhVien);
			}
			
		}
		phieuDKHPRepository.save(phieuDangKyHocPhan);
		
	}

	@Override
	public String autoId() {
		int id = phieuDKHPRepository.autoId();
		String naturalId = "PDK" + String.format("%03d", id+1);
		return naturalId;
	}

}
