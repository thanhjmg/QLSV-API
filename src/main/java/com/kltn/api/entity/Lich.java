package com.kltn.api.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lich {
	@Id
	private String maLich;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLich;
	@Column(columnDefinition = "nvarchar(255)")
	private String loaiLich;
	private Date ngayHoc;
	

	@ManyToOne
	@JoinColumn(name = "maPhong")
	private Phong phong;
	
	@ManyToOne
	@JoinColumn(name = "idNhanVien")
	private NhanVien giangVien;
	
	@ManyToOne
	@JoinColumn(name = "maLopHocPhan")
	private LopHocPhan lopHocPhan;
	
	@ManyToOne
	@JoinColumn(name = "maCaHoc")
	private CaHoc caHoc;
}
