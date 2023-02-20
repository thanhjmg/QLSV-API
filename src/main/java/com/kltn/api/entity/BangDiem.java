package com.kltn.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@IdClass(BangDiemPK.class)
public class BangDiem {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maLopHocPhan")
	private LopHocPhan lopHocPhan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maSinhVien")
	private SinhVien sinhVien;
	
	private float diem;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiBangDiem")
	private LoaiBangDiem loaiBangDiem;
}
