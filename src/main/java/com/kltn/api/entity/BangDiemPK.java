package com.kltn.api.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class BangDiemPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lopHocPhan;
	private String sinhVien;
	
	public BangDiemPK() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(lopHocPhan, sinhVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangDiemPK other = (BangDiemPK) obj;
		return lopHocPhan == other.lopHocPhan && sinhVien == other.sinhVien;
	}
	
	
}
