package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.LopHocPhan;
import com.kltn.api.entity.Phong;
import com.kltn.api.service.LopHocPhanService;

@RestController
@RequestMapping("/api/lophocphan")
public class LopHocPhanRest {
	@Autowired
	private LopHocPhanService lopHocPhanService;
	
	@GetMapping
	public List<LopHocPhan> getAllLopHocPhan(){
		return lopHocPhanService.getAllLopHocPhan();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}", method =   RequestMethod.GET)
	@ResponseBody
	public LopHocPhan getLopHocPhanById(String id) {
		return lopHocPhanService.getLopHocPhanById(id);
	}
	
	
	
	@PostMapping
	public void addLopHocPhan(@RequestBody LopHocPhan lopHocPhan) {
		lopHocPhan.setMaLopHocPhan(lopHocPhanService.autoId());
		lopHocPhanService.saveOrUpdate(lopHocPhan);
	}
	@PutMapping
	public void updateLopHocPhan(@RequestBody LopHocPhan lopHocPhan) {
		
		lopHocPhanService.saveOrUpdate(lopHocPhan);
	}
}
