package com.kltn.api.serviceImlp;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.SinhVienRepository;
import com.kltn.api.entity.SinhVien;
import com.kltn.api.service.SinhVienService;


@Service
@Transactional
public class SinhVienServiceImlp implements SinhVienService{
	
	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public void saveOrUpdateSinhVien(SinhVien sinhVien) {
		sinhVienRepository.save(sinhVien);
		
	}

	@Override
	public List<SinhVien> getAllSinhVien() {
		// TODO Auto-generated method stub
		return sinhVienRepository.findAll();
	}

	@Override
	public SinhVien getNganhHocById(String id) {
		// TODO Auto-generated method stub
		return sinhVienRepository.findById(id).get();
	}

	@Override
	public String autoId() {
		String maSinhVien = "";
	    
	    // Lấy giá trị của maSinhVien cuối cùng từ cơ sở dữ liệu
	    String lastMaSinhVien = sinhVienRepository.findTopByOrderBymaSinhVienDesc();
	    
	    // Lấy năm hiện tại
	    Calendar cal = Calendar.getInstance();
	    int currentYear = cal.get(Calendar.YEAR) % 100; // lấy 2 chữ số cuối của năm hiện tại
	    
	    // Xử lý phần số
	    if (lastMaSinhVien != null && !lastMaSinhVien.equals("") && lastMaSinhVien.length() == 10) {
	        // Lấy phần số (6 chữ số cuối cùng) của maSinhVien cuối cùng
	        int lastNumber = Integer.parseInt(lastMaSinhVien.substring(8));
	        
	        // Nếu năm hiện tại khác năm của maSinhVien cuối cùng, đặt phần số bằng 1
	        if (currentYear != Integer.parseInt(lastMaSinhVien.substring(2, 4))) {
	            lastNumber = 0;
	        }
	        
	        // Tăng phần số lên 1 và cập nhật maSinhVien mới
	        lastNumber++;
	        maSinhVien = String.format("SV%02d%06d", currentYear, lastNumber);
	    } else {
	        // Nếu chưa có maSinhVien nào được lưu trữ trong cơ sở dữ liệu, tạo mới maSinhVien đầu tiên
	        maSinhVien = String.format("SV%02d%06d", currentYear, 1);
	    }
	    
	    return maSinhVien;
	}

}
