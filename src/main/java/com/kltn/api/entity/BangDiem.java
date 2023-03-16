package com.kltn.api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
@IdClass(BangDiemPK.class)
public class BangDiem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "ma_hoc_phan")
	private HocPhan hocPhan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_sinh_vien")
	private SinhVien sinhVien;
	
	@Column(columnDefinition = "float", nullable = true)
	private float thuongKy1;
	@Column(columnDefinition = "float", nullable = true)
	private float thuongKy2;
	@Column(columnDefinition = "float", nullable = true)
	private float thuongKy3;
	@Column(columnDefinition = "float", nullable = true)
	private float thuongKy4;
	@Column(columnDefinition = "float", nullable = true)
	private float thuongKy5;
	
	@Column(columnDefinition = "float", nullable = true)
	private float giuaKy;
	@Column(columnDefinition = "float", nullable = true)
	private float cuoiKy;
	
	@Column(columnDefinition = "float", nullable = true)
	private float thucHanh1;
	@Column(columnDefinition = "float", nullable = true)
	private float thucHanh2;
	@Column(columnDefinition = "float", nullable = true)
	private float thucHanh3;
	@Column(columnDefinition = "float", nullable = true)
	private float diemTongKet;
	
	
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
}
