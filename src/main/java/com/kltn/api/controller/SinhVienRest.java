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

import com.kltn.api.entity.SinhVien;
import com.kltn.api.service.SinhVienService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sinhvien")
@CrossOrigin(origins =   "${client.url}")
@RequiredArgsConstructor
public class SinhVienRest {
	
	@Autowired
	private SinhVienService sinhVienService;
	
	@PostMapping
	public void addSinhVien(@RequestBody SinhVien sinhVien) {
		sinhVien.setMaSinhVien(sinhVienService.autoId());
		sinhVienService.saveOrUpdateSinhVien(sinhVien);
		
	}
	
	@PutMapping
	public void updateSinhVien(@RequestBody SinhVien sinhVien) {

//		sinhVien.setMaSinhVien(sinhVienService.autoId());

		sinhVienService.saveOrUpdateSinhVien(sinhVien);
		
	}

	@GetMapping
	public List<SinhVien> getAllSinhVien() {
		// TODO Auto-generated method stub
		return sinhVienService.getAllSinhVien();
	}
	
	@GetMapping(value = "/{id}")
	public SinhVien getSinhVienById(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return sinhVienService.getSinhVienById(id);
	}
}
