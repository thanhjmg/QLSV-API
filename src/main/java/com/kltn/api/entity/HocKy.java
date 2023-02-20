package com.kltn.api.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HocKy {
	@Id
	private String maHocKy;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenHocKy;
	private Date thoiGianBD;
	private Date thoiGianKT;
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
}
