package com.kltn.api.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietMonHocPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String monHoc;
	private String hocKy;
	@Override
	public int hashCode() {
		return Objects.hash(hocKy, monHoc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietMonHocPK other = (ChiTietMonHocPK) obj;
		return hocKy == other.hocKy && monHoc == other.monHoc;
	}
	
	
}
