package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiMonHoc {
	@Id
	private String maLoaiMonHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoaiMonHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiMonHoc")
	private List<MonHoc> dsMonHoc;
}
