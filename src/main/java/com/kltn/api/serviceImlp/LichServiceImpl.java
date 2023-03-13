package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.CaHocRepository;
import com.kltn.api.dao.LichRepository;
import com.kltn.api.dao.LopHocPhanRepository;
import com.kltn.api.dao.NhanVienRepository;
import com.kltn.api.dao.PhongRepository;
import com.kltn.api.entity.CaHoc;
import com.kltn.api.entity.Lich;
import com.kltn.api.entity.LopHocPhan;
import com.kltn.api.entity.NhanVien;
import com.kltn.api.entity.Phong;
import com.kltn.api.service.LichService;

@Service
@Transactional
public class LichServiceImpl implements LichService{

	@Autowired
	private LichRepository lichRepository;
	@Autowired
	private PhongRepository phongRepository;
	
	@Autowired 
	private NhanVienRepository nhanVienRepository;
	
	@Autowired
	private LopHocPhanRepository lopHocPhanRepository;
	@Autowired 
	private CaHocRepository caHocRepository;
	
	
	@Override
	public void saveOrUpdateLich(Lich lich) {
		// TODO Auto-generated method stub
		if(!lich.getCaHoc().getMaCaHoc().equals("")) {
			var caHoc = caHocRepository.findById(lich.getCaHoc().getMaCaHoc()).get();
			if(caHoc != null) {
				lich.setCaHoc(caHoc);
			}else {
				caHoc = new CaHoc(lich.getCaHoc().getMaCaHoc());
				lich.setCaHoc(caHoc);			}
		}
		if(!lich.getPhong().getMaPhong().equals("")) {
			var phong = phongRepository.findById(lich.getPhong().getMaPhong()).get();
			if(phong != null) {
				lich.setPhong(phong);
			}else {
				phong = new Phong(lich.getPhong().getMaPhong());
				lich.setPhong(phong);			}
		}
		if(!lich.getNhanVien().getMaNhanVien().equals("")) {
			var nhanVien = nhanVienRepository.findById(lich.getNhanVien().getMaNhanVien()).get();
			if(nhanVien != null) {
				lich.setNhanVien(nhanVien);
			}else {
				nhanVien = new NhanVien(lich.getNhanVien().getMaNhanVien());
				lich.setNhanVien(nhanVien);;			}
		}
		if(!lich.getLopHocPhan().getMaLopHocPhan().equals("")) {
			var lopHocPhan = lopHocPhanRepository.findById(lich.getLopHocPhan().getMaLopHocPhan()).get();
			if(lopHocPhan != null) {
				lich.setLopHocPhan(lopHocPhan);
			}else {
				lopHocPhan = new LopHocPhan(lich.getLopHocPhan().getMaLopHocPhan());
				lich.setLopHocPhan(lopHocPhan);			
				}
		}
		lichRepository.save(lich);
		
	}

	@Override
	public List<Lich> getAllLich() {
		// TODO Auto-generated method stub
		return lichRepository.findAll();
	}

	@Override
	public Lich getLichById(String id) {
		// TODO Auto-generated method stub
		return lichRepository.getById(id);
	}

	@Override
	public String autoId() {
		// TODO Auto-generated method stub
		 int id = lichRepository.autoId();
		    String naturalId = "L" + String.format("%03d", id+1);
		    return naturalId;
	}

}
