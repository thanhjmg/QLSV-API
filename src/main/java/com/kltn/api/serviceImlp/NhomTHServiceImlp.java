package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.entity.NhomThucHanh;
import com.kltn.api.repository.LopHocPhanRepository;
import com.kltn.api.repository.NhomTHRepository;
import com.kltn.api.service.NhomTHService;

@Service
@Transactional
public class NhomTHServiceImlp implements NhomTHService{
	
	@Autowired
	private NhomTHRepository nhomTHRepository;
	@Autowired
	private LopHocPhanRepository lopHocPhanRepository;

	@Override
	public void saveOrUpdateNhomTH(NhomThucHanh nhomThucHanh) {
		// TODO Auto-generated method stub
		var lhp = lopHocPhanRepository.findById(nhomThucHanh.getLopHocPhan().getMaLopHocPhan()).get();
		nhomThucHanh.setLopHocPhan(lhp);
		nhomTHRepository.save(nhomThucHanh);
	}

	@Override
	public List<NhomThucHanh> getAllNhomTH() {
		// TODO Auto-generated method stub
		return nhomTHRepository.findAll();
	}

	@Override
	public String autoId() {
		int id = nhomTHRepository.autoId();
	    String naturalId = "NTH" + String.format("%05d", id+1);
	    return naturalId;
	}

}
