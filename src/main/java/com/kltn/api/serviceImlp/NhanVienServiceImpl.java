package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.entity.NhanVien;
import com.kltn.api.repository.NhanVienRepository;
import com.kltn.api.service.NhanVienService;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService{
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Override
	public void saveOrUpdateNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		nhanVienRepository.save(nhanVien);
		
	}

	@Override
	public List<NhanVien> getAllNhanVien() {
		// TODO Auto-generated method stub
		return nhanVienRepository.findAll();
	}

	@Override
	public NhanVien getNhanVienById(String id) {
		// TODO Auto-generated method stub
		return nhanVienRepository.getById(id);
	}

	@Override
	public String autoId() {
		// TODO Auto-generated method stub
		String maNhanVien="";
		String lastMaNhanVien = nhanVienRepository.findTopByOrderBymaNhanVienDesc();
		if(lastMaNhanVien != null && !lastMaNhanVien.equals("") && lastMaNhanVien.length()==8) {
			int lastNumber = Integer.parseInt(lastMaNhanVien.substring(6));
			lastNumber++;
			maNhanVien = String.format("NV%06d", lastNumber);
		}else {
			maNhanVien = String.format("NV%06d", 1);
		}
		return maNhanVien;
	}

}
