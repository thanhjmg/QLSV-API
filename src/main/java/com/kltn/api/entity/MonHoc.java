package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MonHoc {
	@Id
	private String maMonHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenMonHoc;
	private Integer soTCLT;
	private Integer soTCTH;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiMonHoc")
	private LoaiMonHoc loaiMonHoc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "monHoc")
	private List<DieuKienMonHoc> dieuKienMonHoc;
}
