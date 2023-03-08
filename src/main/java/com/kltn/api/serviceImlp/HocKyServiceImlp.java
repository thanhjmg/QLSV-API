package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.HocKyRepository;
import com.kltn.api.entity.HocKy;
import com.kltn.api.service.HocKyService;

@Service
@Transactional
public class HocKyServiceImlp implements  HocKyService{
	
	@Autowired
	private HocKyRepository hocKyRepository;

	@Override
	public List<HocKy> getAllKhoa() {
		// TODO Auto-generated method stub
		return hocKyRepository.findAll();
	}

	@Override
	public HocKy getHocKyById(String id) {
		// TODO Auto-generated method stub
		return hocKyRepository.findById(id).get();
	}

	@Override
	public void addOrUpdateHocKy(HocKy hocKy) {
		hocKyRepository.save(hocKy);
		
	}

	@Override
	public String autoId() {
		int id = hocKyRepository.autoId();
		String naturalId = "HK" + String.format("%03d", id+1);
		return naturalId;
	}

}
