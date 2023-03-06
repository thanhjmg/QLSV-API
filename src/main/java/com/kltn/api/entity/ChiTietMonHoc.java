package com.kltn.api.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@IdClass(ChiTietMonHocPK.class)
@Table
@Data
public class ChiTietMonHoc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "maMonHoc")
	private MonHoc monHoc;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHocKy")
	private HocKy hocKy;
}
