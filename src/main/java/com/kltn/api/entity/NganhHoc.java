package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class NganhHoc {
	@Id
	private String maNganh;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenNganh;
	private Integer tongTinChi;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maKhoa")
	private Khoa khoa;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nganhHoc")
	private List<LopHoc> dsLop;
	
	@OneToOne(mappedBy = "nganhHoc")
	private ChuongTrinhKhung chuongTrinhKhung;
	
	public NganhHoc() {
		// TODO Auto-generated constructor stub
	}

	
}
