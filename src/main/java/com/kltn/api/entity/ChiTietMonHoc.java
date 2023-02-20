package com.kltn.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(ChiTietMonHocPK.class)
public class ChiTietMonHoc {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maMonHoc")
	private MonHoc monHoc;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHocKy")
	private HocKy hocKy;
}
