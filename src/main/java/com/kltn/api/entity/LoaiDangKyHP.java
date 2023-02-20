package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiDangKyHP {
	@Id
	private String maLoaiDKHP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoaiDKHP;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loaiDangKyHP")
	private List<ChiTietPhieuDangKy> dsChiTietPhieuDangKi;
		
}
