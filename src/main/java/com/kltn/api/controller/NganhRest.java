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

import com.kltn.api.entity.NganhHoc;
import com.kltn.api.service.NganhHocService;

@RestController()
@RequestMapping("/api/nganh")
public class NganhRest {
	
	@Autowired
	private NganhHocService nganhHocService;
	
	@PostMapping()
	public void addNganhHoc(@RequestBody NganhHoc nganhHoc) {
		nganhHoc.setMaNganh(nganhHocService.autoId());
		nganhHocService.saveOrUpdateNganhHoc(nganhHoc);
		
	}
	
	@PutMapping
	public void updateNganhHoc(@RequestBody NganhHoc nganhHoc) {
		//nganhHoc.setMaNganh(nganhHocService.autoId());
		nganhHocService.saveOrUpdateNganhHoc(nganhHoc);
		
	}
	@GetMapping
	public List<NganhHoc> getAllNganhHoc() {
		// TODO Auto-generated method stub
		return nganhHocService.getAllNganhHoc();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public NganhHoc getNganhHocById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return nganhHocService.getNganhHocById(id);
	}
}
