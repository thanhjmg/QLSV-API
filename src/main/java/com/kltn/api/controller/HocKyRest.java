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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.HocKy;
import com.kltn.api.service.HocKyService;

@RestController
@RequestMapping("/api/hocky")
public class HocKyRest {
	
	@Autowired
	private HocKyService hocKyService;
	
	@GetMapping
	public List<HocKy> getAllKhoa() {
		// TODO Auto-generated method stub
		return hocKyService.getAllKhoa();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public HocKy getHocKyById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return hocKyService.getHocKyById(id);
	}

	@PostMapping
	public void addHocKy(@RequestBody HocKy hocKy) {
		hocKy.setMaHocKy(hocKyService.autoId());
		hocKyService.addOrUpdateHocKy(hocKy);
	}
	
	@PutMapping
	public void updateHocKy(@RequestBody HocKy hocKy) {
		hocKyService.addOrUpdateHocKy(hocKy);
	}
}
