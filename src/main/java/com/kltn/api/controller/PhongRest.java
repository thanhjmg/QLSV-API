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

import com.kltn.api.entity.Phong;
import com.kltn.api.service.PhongService;

@RestController
@RequestMapping("/api/phong")
public class PhongRest {

	@Autowired
	private PhongService phongService;
	@GetMapping
	public List<Phong> getAllPhong(){
		return phongService.getAllPhong();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}", method =   RequestMethod.GET)
	@ResponseBody
	public Phong getPhongById(String id) {
		return phongService.getPhongById(id);
	}
	
	@PostMapping
	public void addPhong(@RequestBody Phong phong) {
		phong.setMaPhong(phongService.autoId());
		phongService.addOrUpdatePhong(phong);
	}
	@PutMapping
	public void updatePhong(@RequestBody Phong phong) {
		phongService.addOrUpdatePhong(phong);
	}
}
