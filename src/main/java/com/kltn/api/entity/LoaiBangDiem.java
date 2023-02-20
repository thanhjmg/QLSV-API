package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiBangDiem {
	@Id
	private String maLoaiBangDiem;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoaiBangDiem;
	private Integer heSo;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiBangDiem")
	private List<BangDiem> dsBangDiem;
}
