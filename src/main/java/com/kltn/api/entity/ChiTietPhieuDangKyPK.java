package com.kltn.api.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietPhieuDangKyPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lopHocPhan;
	private String phieuDangKyHocPhan;
	@Override
	public int hashCode() {
		return Objects.hash(lopHocPhan, phieuDangKyHocPhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuDangKyPK other = (ChiTietPhieuDangKyPK) obj;
		return Objects.equals(lopHocPhan, other.lopHocPhan) && Objects.equals(phieuDangKyHocPhan, other.phieuDangKyHocPhan);
	}
	
	
	
}
