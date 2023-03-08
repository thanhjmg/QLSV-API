package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.MonHoc;
import com.kltn.api.service.MonHocService;

@RestController
@RequestMapping("/api/monhoc")
public class MonHocRest {

	@Autowired
	private MonHocService monHocService;

	@GetMapping
	public List<MonHoc> getAllMonHoc() {
		// TODO Auto-generated method stub
		return monHocService.getAllMonHoc();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MonHoc getMonHocById(String id) {
		// TODO Auto-generated method stub
		return monHocService.getMonHocById(id);
	}

	@PostMapping
	public void addMonHoc(@RequestBody MonHoc monHoc) {
		monHoc.setMaMonHoc(monHocService.autoId());
		monHocService.addOrUpdateMonHoc(monHoc);
	}
	
	@PutMapping
	public void updateMonHoc(@RequestBody MonHoc monHoc) {
		
		monHocService.addOrUpdateMonHoc(monHoc);
	}
}
