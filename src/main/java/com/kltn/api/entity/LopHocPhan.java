package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LopHocPhan {
	@Id
	private String maLopHocPhan;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLopHocPhan;
	private Integer siSo;
	private Integer siSoThuc;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "lopHocPhan")
	private List<Lich> dsLich;
}
