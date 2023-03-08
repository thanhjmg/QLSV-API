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

import com.kltn.api.entity.PhieuDangKyHocPhan;
import com.kltn.api.service.PhieuDKHPService;

@RestController
@RequestMapping("/api/phieudkhp")
public class PhieuDKHPRest {
	
	@Autowired
	private PhieuDKHPService phieuDKHPService;
	
	@GetMapping
	public List<PhieuDangKyHocPhan> getAllPhieuDKHP() {
		// TODO Auto-generated method stub
		return phieuDKHPService.getAllPhieuDKHP();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PhieuDangKyHocPhan getPhieuDKHPById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return phieuDKHPService.getPhieuDKHPById(id);
	}

	@PostMapping
	public void addKhoa(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdateKhoa(phieuDangKyHocPhan);
	}
	
	@PutMapping
	public void updateKhoa(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdateKhoa(phieuDangKyHocPhan);
	}
}
