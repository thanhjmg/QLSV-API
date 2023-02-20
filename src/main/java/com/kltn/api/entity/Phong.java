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
public class Phong {
	@Id
	private String maPhong;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenPhong;
	private Integer soGhe;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiPhong")
	private LoaiPhong loaiPhong;
	
	@ManyToOne
	@JoinColumn(name = "maDayNha")
	private DayNha dayNha;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "phong")
	private List<Lich> dsLich;
}
