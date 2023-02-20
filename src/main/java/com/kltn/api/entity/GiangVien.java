package com.kltn.api.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class GiangVien {
	@Id
	private String maGiangVien;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenGiangVien;
	@Column( columnDefinition = "nvarchar(255)")
	private String chucVu;
	private Boolean gioiTinh;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	//@OneToOne
	//@PrimaryKeyJoinColumn
	//@JoinColumn(name = "maHoSo", nullable = false)
	
	@Embedded
	private HoSo hoSo;
	
	@ManyToOne
    @JoinColumn(name = "maKhoa")
	private Khoa khoa;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "giangVien")
	private List<Lich> dsLich;
	
	public GiangVien() {
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String maGiangVien, String tenGiangVien, String chucVu, Boolean gioiTinh, String trangThai) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.trangThai = trangThai;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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
