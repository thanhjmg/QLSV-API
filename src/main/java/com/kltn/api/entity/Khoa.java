package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Khoa {
	@Id
	private String maKhoa;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenKhoa;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
	private List<GiangVien> dsGiangVien;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
	private List<NganhHoc> dsNganhHoc;
	
	public Khoa() {
		// TODO Auto-generated constructor stub
	}

	public Khoa(String maKhoa, String tenKhoa, String trangThai) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.trangThai = trangThai;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
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
