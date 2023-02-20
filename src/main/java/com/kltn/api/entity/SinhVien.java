package com.kltn.api.entity;

import java.sql.Date;
import java.util.List;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "SinhVien")
public class SinhVien {
	@Id
	private String maSinhVien;
	@Column(name = "tenSinhVien", columnDefinition = "nvarchar(255)")
	private String tenSinhVien;
	private Boolean gioiTinh;
	@Column( columnDefinition = "nvarchar(255)")
	private Date ngayVaoTruong;
	@Column( columnDefinition = "nvarchar(255)")
	private String khoaHoc;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maLop")
	private LopHoc lopHoc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "sinhVien")
	private List<PhieuDangKyHocPhan> dsPhieuDangKyHocPhan;
	
	//@OneToOne
	//@PrimaryKeyJoinColumn
	 //@JoinColumn(name = "maHoSo", nullable = false)
	
	@Embedded
	private HoSo hoSo;

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String maSinhVien, String tenSinhVien, Boolean gioiTinh, Date ngayVaoTruong, String khoaHoc,
			String trangThai) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngayVaoTruong = ngayVaoTruong;
		this.khoaHoc = khoaHoc;
		this.trangThai = trangThai;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgayVaoTruong() {
		return ngayVaoTruong;
	}

	public void setNgayVaoTruong(Date ngayVaoTruong) {
		this.ngayVaoTruong = ngayVaoTruong;
	}

	public String getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(String khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", gioiTinh=" + gioiTinh
				+ ", ngayVaoTruong=" + ngayVaoTruong + ", khoaHoc=" + khoaHoc + ", trangThai=" + trangThai + "]";
	}


}
