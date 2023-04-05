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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.ChiTietPhieuDangKy;
import com.kltn.api.entity.PhieuDangKyHocPhan;
import com.kltn.api.service.PhieuDKHPService;

@RestController
@RequestMapping("/api/phieudkhp")
@CrossOrigin(origins =   "${client.url}")
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
	public void addPhieuDK(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdatePhieuDK(phieuDangKyHocPhan);
	}
	
	@PutMapping
	public void updatePhieuDK(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdatePhieuDK(phieuDangKyHocPhan);
	}
	
	@PostMapping("/add-ctpdk")
	public void addChiTietPhieuDK(@RequestBody ChiTietPhieuDangKy chiTietPhieuDangKy) {
		
		phieuDKHPService.addChiTietPhieuDKHP(chiTietPhieuDangKy);
	}
	
	@GetMapping("/lhp")
	public List<ChiTietPhieuDangKy> getListChiTietPDKByMaLHP(@RequestParam("maLHP") String maLHP,@RequestParam("maNhom") String maNhom) {
		// TODO Auto-generated method stub
		return phieuDKHPService.getListChiTietPDKByMaLHP(maLHP, maNhom);
	}

}
