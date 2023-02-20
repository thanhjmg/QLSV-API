package com.kltn.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ChuongTrinhKhung {
	@Id
	private String maChuongTrinhKhung;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenChuongTrinhKhung;
	private String trangThai;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maNganh")
	private NganhHoc nganhHoc;
}
