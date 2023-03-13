package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.entity.Khoa;
import com.kltn.api.entity.LoaiMonHoc;
import com.kltn.api.entity.MonHoc;
import com.kltn.api.repository.LoaiMonHocRepository;
import com.kltn.api.repository.MonHocRepository;
import com.kltn.api.service.MonHocService;

@Service
@Transactional
public class MonHocServiceImlp implements MonHocService{
	
	@Autowired
	private MonHocRepository monHocRepository;
	@Autowired
	private LoaiMonHocRepository loaiMonHocRepository;

	@Override
	public List<MonHoc> getAllMonHoc() {
		// TODO Auto-generated method stub
		return monHocRepository.findAll();
	}

	@Override
	public MonHoc getMonHocById(String id) {
		// TODO Auto-generated method stub
		return monHocRepository.findById(id).get();
	}

	@Override
	public void addOrUpdateMonHoc(MonHoc monHoc) {
		if(!monHoc.getLoaiMonHoc().getMaLoaiMonHoc().equals("")) {
			var loaiMH = loaiMonHocRepository.findById(monHoc.getLoaiMonHoc().getMaLoaiMonHoc()).get();
			
			if(loaiMH != null) {
				monHoc.setLoaiMonHoc(loaiMH);
			}
			else {
				loaiMH = new LoaiMonHoc(monHoc.getLoaiMonHoc().getMaLoaiMonHoc());
				monHoc.setLoaiMonHoc(loaiMH);
			}
			
		}
		monHocRepository.save(monHoc);
	}

	@Override
	public String autoId() {
		int id = monHocRepository.autoId();
	    String maMH = "MH" + String.format("%03d", id+1);
	    return maMH;
	}

}
