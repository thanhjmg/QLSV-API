package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiPhong {
	@Id
	private String maLoaiPhong;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoaiPhong;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loaiPhong")
	private List<Phong> dsPhong;
	
}
