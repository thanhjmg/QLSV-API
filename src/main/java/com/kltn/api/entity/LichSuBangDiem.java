package com.kltn.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class LichSuBangDiem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private String maLichSuBangDiem;

    @ManyToOne
    @JoinColumn(name = "ma_bang_diem")
    private BangDiem bangDiem;
    
    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;
    
    private LocalDateTime thoiGian;
}
