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

import com.kltn.api.entity.LoaiMonHoc;
import com.kltn.api.service.LoaiMonHocService;

@RestController
@RequestMapping("/api/loaimonhoc")
@CrossOrigin(origins =  "${client.url}")
public class LoaiMonHocRest {
	
	@Autowired
	LoaiMonHocService loaiMonHocService;
	
	@PostMapping
	public void addLoaiMonHoc( @RequestBody LoaiMonHoc loaiMonHoc) {
		loaiMonHoc.setMaLoaiMonHoc(loaiMonHocService.autoId());
		loaiMonHocService.saveOrUpdateLoaiMonHoc(loaiMonHoc);
		
	}
	
	@PutMapping
	public void updateLoaiMonHoc( @RequestBody LoaiMonHoc loaiMonHoc) {
		//loaiMonHoc.setMaLoaiMonHoc(loaiMonHocService.autoId());
		loaiMonHocService.saveOrUpdateLoaiMonHoc(loaiMonHoc);
		
	}

	@GetMapping
	public List<LoaiMonHoc> getAllLoaiMonHoc() {
		// TODO Auto-generated method stub
		return loaiMonHocService.getAllLoaiMonHoc();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public LoaiMonHoc getLoaiMonHocById(@PathVariable(name = "id") String id) {
		// TODO Auto-generated method stub
		return loaiMonHocService.getLoaiMonHocById(id);
	}

}
