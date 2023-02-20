package com.kltn.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PhieuDangKyHocPhan {
	@Id
	private String maPhieuDangKy;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maSinhVien")
	private SinhVien sinhVien;
}
