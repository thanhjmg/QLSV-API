package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.LichSuBangDiem;
import com.kltn.api.service.LichSuBDService;

@RestController
@RequestMapping("/api/lichsu")
public class LichSuBDRest {
	 @Autowired
	 private LichSuBDService lichSuBDService;
	 
	 @PostMapping
	 public void saveLichSuBD(LichSuBangDiem lichSuBangDiem) {
			// TODO Auto-generated method stub
		 lichSuBangDiem.setMaLichSuBangDiem(lichSuBDService.autoId());
		 lichSuBDService.saveOrUpdateLichSuBD(lichSuBangDiem);
		}

		@GetMapping
		public List<LichSuBangDiem> getAllLichSu() {
			// TODO Auto-generated method stub
			return lichSuBDService.getAllLichSu();
		}
}
