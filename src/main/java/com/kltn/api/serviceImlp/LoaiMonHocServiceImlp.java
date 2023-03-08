package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.LoaiMonHocRepository;
import com.kltn.api.entity.LoaiMonHoc;
import com.kltn.api.entity.LopHoc;
import com.kltn.api.service.LoaiMonHocService;

@Service
@Transactional
public class LoaiMonHocServiceImlp implements LoaiMonHocService{
	
	@Autowired
	private LoaiMonHocRepository loaiMonHocRepository;

	@Override
	public void saveOrUpdateLoaiMonHoc(LoaiMonHoc loaiMonHoc) {
		
		loaiMonHocRepository.save(loaiMonHoc);
		
	}

	@Override
	public List<LoaiMonHoc> getAllLoaiMonHoc() {
		// TODO Auto-generated method stub
		return loaiMonHocRepository.findAll();
	}

	@Override
	public LoaiMonHoc getLoaiMonHocById(String id) {
		// TODO Auto-generated method stub
		return loaiMonHocRepository.findById(id).get();
	}

	@Override
	public String autoId() {
		int id = loaiMonHocRepository.findTopByOrderByLoaiMonHocDesc();
	    String maLoai = "LMH" + String.format("%03d", id+1);
	    return maLoai;
	}

}
