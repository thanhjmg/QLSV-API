package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kltn.api.entity.LichSuBangDiem;
import com.kltn.api.repository.LichSuBDRepository;
import com.kltn.api.service.LichSuBDService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LichSuBDServiceImlp implements LichSuBDService{
	
	@Autowired
	private LichSuBDRepository lichSuBDRepository;

	@Override
	public void saveOrUpdateLichSuBD(LichSuBangDiem lichSuBangDiem) {
		// TODO Auto-generated method stub
		 lichSuBDRepository.save(lichSuBangDiem);
	}

	@Override
	public List<LichSuBangDiem> getAllLichSu() {
		// TODO Auto-generated method stub
		return lichSuBDRepository.findAll();
	}

	@Override
	public String autoId() {
		int id = lichSuBDRepository.autoId();
		String naturalId = "LSBD" + String.format("%05d", id+1);
		return naturalId;
	}

}
