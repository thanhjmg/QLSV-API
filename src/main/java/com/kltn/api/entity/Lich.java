package com.kltn.api.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lich {
	@Id
	private String maLich;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLich;
	@Column(columnDefinition = "nvarchar(255)")
	private String loaiLich;
	private Date ngayHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String caHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;

	@ManyToOne
	@JoinColumn(name = "maPhong")
	private Phong phong;
	
	@ManyToOne
	@JoinColumn(name = "maGiangVien")
	private GiangVien giangVien;
	
	@ManyToOne
	@JoinColumn(name = "maLopHocPhan")
	private LopHocPhan lopHocPhan;
}
