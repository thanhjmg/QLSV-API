package com.kltn.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiMonHoc {
	@Id
	private String maLoaiMonHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoaiMonHoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	public LoaiMonHoc(String maLoaiMonHoc) {
		super();
		this.maLoaiMonHoc = maLoaiMonHoc;
	}
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiMonHoc")
//	private List<MonHoc> dsMonHoc;
}
