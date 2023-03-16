package com.kltn.api.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietHocPhanPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hocPhan;
	private String hocKy;
	@Override
	public int hashCode() {
		return Objects.hash(hocKy, hocPhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHocPhanPK other = (ChiTietHocPhanPK) obj;
		return hocKy == other.hocKy && hocPhan == other.hocPhan;
	}
	
	
}
