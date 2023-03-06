package com.kltn.api.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietHocKyPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hocKy;
	private String chuongTrinhKhung;
	
	public ChiTietHocKyPK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(chuongTrinhKhung, hocKy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHocKyPK other = (ChiTietHocKyPK) obj;
		return chuongTrinhKhung == other.chuongTrinhKhung && hocKy == other.hocKy;
	}
	
	
}
