package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.LichRepository;
import com.kltn.api.dao.PhongRepository;
import com.kltn.api.entity.Lich;
import com.kltn.api.service.LichService;

@Service
@Transactional
public class LichServiceImpl implements LichService{

	@Autowired
	private LichRepository lichRepository;
	@Autowired PhongRepository phongRepository;
	
	@Override
	public void saveOrUpdateLich(Lich lich) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public List<Lich> getAllLich() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lich getLichById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String autoId() {
		// TODO Auto-generated method stub
		return null;
	}

}
