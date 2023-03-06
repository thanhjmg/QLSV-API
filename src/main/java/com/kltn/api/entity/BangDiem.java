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
	@JoinColumn(name = "idLopHocPhan")
	private LopHocPhan lopHocPhan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idSinhVien")
	private SinhVien sinhVien;
	
	private float diem;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiBangDiem")
	private LoaiBangDiem loaiBangDiem;
	
}
