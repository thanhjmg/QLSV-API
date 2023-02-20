package com.kltn.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(ChiTietHocKyPK.class)
public class ChiTietHocKy {
	@Id
	@ManyToOne
	@JoinColumn(name = "maChuongTrinhKhung")
	private ChuongTrinhKhung chuongTrinhKhung;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHocKy")
	private HocKy hocKy;
}
