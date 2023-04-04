package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.NhomThucHanh;
import com.kltn.api.service.NhomTHService;

@RestController
@RequestMapping("/api/nhomTH")
public class NhomTHRest {
	@Autowired
	private NhomTHService nhomTHService;
	
	@PostMapping
	public void saveOrUpdateNhomTH(@RequestBody NhomThucHanh nhomThucHanh) {
		// TODO Auto-generated method stub
		nhomThucHanh.setMaNhom(nhomTHService.autoId());
		nhomTHService.saveOrUpdateNhomTH(nhomThucHanh);
	}

	@GetMapping
	public List<NhomThucHanh> getAllNhomTH() {
		// TODO Auto-generated method stub
		return nhomTHService.getAllNhomTH();
	}


}
