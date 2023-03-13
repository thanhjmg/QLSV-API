package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.entity.LopHocPhan;
import com.kltn.api.repository.LopHocPhanRepository;
import com.kltn.api.service.LopHocPhanService;

@Service
@Transactional
public class LopHocPhanServiceImpl implements LopHocPhanService{
	
	@Autowired
	private LopHocPhanRepository lopHocPhanRepository;
	

	@Override
	public void saveOrUpdate(LopHocPhan lopHocPhan) {
		// TODO Auto-generated method stub
		lopHocPhanRepository.save(lopHocPhan);
		
	}

	@Override
	public List<LopHocPhan> getAllLopHocPhan() {
		// TODO Auto-generated method stub
		return lopHocPhanRepository.findAll();
	}

	@Override
	public LopHocPhan getLopHocPhanById(String id) {
		// TODO Auto-generated method stub
		return lopHocPhanRepository.getById(id);
	}

	@Override
	public String autoId() {
		int id = lopHocPhanRepository.autoId();
		String naturalId = "LHP" + String.format("%03d", id+1);
		return naturalId;
	}

}
