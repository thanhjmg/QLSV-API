package com.kltn.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DieuKienMonHoc {
	@Id
	private String maDieuKien;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenDieuKien;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maMonHoc")
	private MonHoc monHoc;
	
	public DieuKienMonHoc() {
		// TODO Auto-generated constructor stub
	}
}
