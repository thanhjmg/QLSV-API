package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.kltn.api.entity.BangDiem;
import com.kltn.api.entity.Khoa;
import com.kltn.api.entity.LopHocPhan;
import com.kltn.api.entity.Phong;
import com.kltn.api.service.LopHocPhanService;

@RestController
@RequestMapping("/api/lophocphan")
@CrossOrigin(origins =  "${client.url}")
public class LopHocPhanRest {
	@Autowired
	private LopHocPhanService lopHocPhanService;
	
	@GetMapping
	public List<LopHocPhan> getAllLopHocPhan(){
		return lopHocPhanService.getAllLopHocPhan();
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}", method =RequestMethod.GET)
	@ResponseBody
	public LopHocPhan getLopHocPhanById(String id) {
		return lopHocPhanService.getLopHocPhanById(id);
	}
	
	
	
	@PostMapping
	public LopHocPhan addLopHocPhan(@RequestBody LopHocPhan lopHocPhan) {
		lopHocPhan.setMaLopHocPhan(lopHocPhanService.autoId());
		lopHocPhanService.saveOrUpdate(lopHocPhan);
		return lopHocPhan;
	}
	@PutMapping
	public LopHocPhan updateLopHocPhan(@RequestBody LopHocPhan lopHocPhan) {
		
		lopHocPhanService.saveOrUpdate(lopHocPhan);
		return lopHocPhan;
	}
	
	@GetMapping("/hocphan")
	public List<LopHocPhan> getLopHocPhanTheoMaHocPhan(@RequestParam("maHP") String maHP,@RequestParam("maHK") String maHK) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getLopHocPhanTheoMaHocPhan(maHP,maHK);
	}

	@GetMapping("/mahocphan")
	public List<LopHocPhan> getLopHocPhanTheoMaHP(@RequestParam("maHP") String maHP) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getLopHocPhanTheoMaHP(maHP);
	}

	@GetMapping("/giangvien")
	public List<LopHocPhan> getTatCaLHPByHocPhanAndMaGVAndMaHK(@RequestParam("maGV") String maGV,@RequestParam("maHK") String maHK,@RequestParam("maHP") String maHP) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getTatCaLHPByHocPhanAndMaGVAndMaHK(maGV, maHK, maHP);

	}
	
	@GetMapping("/bangdiem")
	public List<BangDiem> getBangDiemTheoLHP(@RequestParam("maLHP") String maLHP) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getBangDiemTheoLHPAndMaSV(maLHP);
	}
	
	@PostMapping("/bangdiem")
	public BangDiem addBangDiem(@RequestBody BangDiem bangDiem) {
		bangDiem.setMaBangDiem(lopHocPhanService.autoIdBangDiem());
		lopHocPhanService.addBangDiem(bangDiem);
		return bangDiem;
	}
	@PutMapping("/bangdiem")
	public BangDiem updateBangDiem(@RequestBody BangDiem bangDiem) {
		lopHocPhanService.addBangDiem(bangDiem);
		return bangDiem;
	}
	
	@GetMapping("/search")
	public List<LopHocPhan> getLopHocPhanByTextSearch(@RequestParam("valueSearch") String valueSearch) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getLopHocPhanByTextSearch(valueSearch);
	}
	
	@GetMapping("/malophocphan")
	public LopHocPhan getLopHocPhanByMaLHP(@RequestParam("maLHP") String maLHP) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getLopHocPhanByMaLHP(maLHP);
	}
	
	@GetMapping("/bangdiemsvandhk")
	public List<BangDiem> getBangDiemBySVAndHK(@RequestParam("maSinhVien") String maSinhVien,@RequestParam("maHK") String maHK) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getBangDiemBySVAndHK(maSinhVien, maHK);
	}
	@GetMapping("/bangdiemkhongdat")
	public List<BangDiem> getBangDiemKhongDat(@RequestParam("maSinhVien") String maSinhVien) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getBangDiemKhongDat(maSinhVien);
	}
	@GetMapping("/diemtbtheohk")
	public float diemTBTheoHK(@RequestParam("maSinhVien") String maSinhVien,@RequestParam("maHK") String maHK) {
		// TODO Auto-generated method stub
		return lopHocPhanService.diemTBTheoHK(maSinhVien, maHK);
	}
	
	@DeleteMapping("/delete")
	public void xoaLopHocPhanTheoMaLHP(@RequestParam String maLHP) {
		// TODO Auto-generated method stub
		lopHocPhanService.xoaLopHocPhanTheoMaLHP(maLHP);
	}
	
}
