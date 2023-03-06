package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.LopHoc;
import com.kltn.api.service.LopHocService;

@RestController
@RequestMapping("/api/lophoc")
public class LopHocRest {
	@Autowired
	private LopHocService lopHocService;
	
	@PostMapping()
	public void addLopHoc(@RequestBody LopHoc lopHoc) {
		lopHoc.setMaLop(lopHocService.autoId());
		lopHocService.saveOrUpdateLopHoc(lopHoc);
	}
	
	@PutMapping()
	public void updateLopHoc(@RequestBody LopHoc lopHoc) {
		//lopHoc.setMaLop(lopHocService.autoId());
		lopHocService.saveOrUpdateLopHoc(lopHoc);
	}
	
	@GetMapping
	public List<LopHoc> getAllLopHoc() {
		// TODO Auto-generated method stub
		return lopHocService.getAllLopHoc();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public LopHoc getLopHocById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return lopHocService.getLopHocById(id);
	}
}
