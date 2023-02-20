package com.kltn.api.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(ChiTietPhieuDangKyPK.class)
public class ChiTietPhieuDangKy {
	@Id
	@ManyToOne
	@JoinColumn(name = "maMonHoc")
	private MonHoc monHoc;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maPhieuDangKy")
	private PhieuDangKyHocPhan phieuDangKyHocPhan;
	
	private Date ngayDangKy;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiDKHP")
	private LoaiDangKyHP loaiDangKyHP;
}
