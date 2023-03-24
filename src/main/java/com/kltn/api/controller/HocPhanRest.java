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

import com.kltn.api.entity.HocPhan;
import com.kltn.api.entity.MonHoc;
import com.kltn.api.service.HocPhanService;

@RestController
@RequestMapping("/api/hocphan")
@CrossOrigin(origins =  "${client.url}")
public class HocPhanRest {
	
	@Autowired
	private HocPhanService hocPhanService;
	
	@PostMapping
	public void addHocPhan(@RequestBody HocPhan hocPhan) {
		hocPhan.setMaHocPhan(hocPhanService.autoId());
		hocPhanService.saveOrUpdateHocPhan(hocPhan);
	}
	
	@PutMapping
	public void updateHocPhan(HocPhan hocPhan) {
		hocPhanService.saveOrUpdateHocPhan(hocPhan);
	}


	@GetMapping
	public List<HocPhan> getAllHocPhan() {
		// TODO Auto-generated method stub
		return hocPhanService.getAllHocPhan();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public HocPhan getHocPhanById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return hocPhanService.getHocPhanById(id);
	}
}
