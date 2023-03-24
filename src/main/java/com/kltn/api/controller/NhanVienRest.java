package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.NhanVien;
import com.kltn.api.entity.SinhVien;
import com.kltn.api.service.NhanVienService;

@RestController
@RequestMapping("/api/nhanvien")
@CrossOrigin(origins =  "${client.url}")
public class NhanVienRest {
	@Autowired
	private NhanVienService nhanVienService;
	
	@PostMapping
	public void addNhanVien(@RequestBody NhanVien nhanVien) {
		nhanVien.setMaNhanVien(nhanVienService.autoId());
		nhanVienService.saveOrUpdateNhanVien(nhanVien);
		
	}
	
	@PutMapping
	public void updateNhanVien(@RequestBody NhanVien nhanVien) {

//		sinhVien.setMaSinhVien(sinhVienService.autoId());

		nhanVienService.saveOrUpdateNhanVien(nhanVien);
		
	}
	@GetMapping
	public List<NhanVien> getAllNhanVien() {
		// TODO Auto-generated method stub
		return nhanVienService.getAllNhanVien();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public NhanVien getNhanVienById(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		return nhanVienService.getNhanVienById(id);
	}
}
