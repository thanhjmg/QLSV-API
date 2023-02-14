package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.HoSo;
import com.kltn.api.service.HoSoService;

@RestController
@RequestMapping("/api")
public class HoSoRestController {
	@Autowired
	private HoSoService hoSoService;

	@PostMapping("/hoso")
	public HoSo luuHoSo(@RequestBody HoSo hoSo) {
		hoSoService.luuHoSo(hoSo);
		return hoSo;
		
	}
	
	@GetMapping("/hoso")
	public List<HoSo> getHoSo() {

		return hoSoService.getHoSo();
	}
}
