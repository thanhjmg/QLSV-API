package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class LopHoc {
	@Id
	private String maLop;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenLop;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;

	@ManyToOne
	@JoinColumn(name = "maNganh")
	private NganhHoc nganhHoc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lopHoc")
	private List<SinhVien> dsSinhVien;
	
	public LopHoc() {
		// TODO Auto-generated constructor stub
	}



	public LopHoc(String maLop, String tenLop, String trangThai) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.trangThai = trangThai;
	}



	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
