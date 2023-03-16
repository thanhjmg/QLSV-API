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
	private String hocPhan;
	private String phieuDangKyHocPhan;
	@Override
	public int hashCode() {
		return Objects.hash(hocPhan, phieuDangKyHocPhan);
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
		return Objects.equals(hocPhan, other.hocPhan) && Objects.equals(phieuDangKyHocPhan, other.phieuDangKyHocPhan);
	}
	
	
	
}
