package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChiTietHocPhan;
import com.kltn.api.entity.Lich;

public interface LichRepository extends JpaRepository<Lich, String> {
	@Query("SELECT COUNT(*) val_count FROM Lich")
	public int autoId();
	
	@Query(value = "select lich.* from lich where ma_lop_hoc_phan like :maLHP", nativeQuery = true)
	public List<Lich> getTatCaLichTheoMaLHP(@Param("maLHP") String maLHP);
	

//	@Query(value = "SELECT lich.*\r\n"
//			+ "FROM     sinh_vien INNER JOIN\r\n"
//			+ "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
//			+ "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
//			+ "                  lop_hoc_phan ON chi_tiet_phieu_dang_ky.ma_lop_hoc_phan = lop_hoc_phan.ma_lop_hoc_phan INNER JOIN\r\n"
//			+ "                  lich ON lop_hoc_phan.ma_lop_hoc_phan = lich.ma_lop_hoc_phan\r\n"
//			+ "				  where sinh_vien.ma_sinh_vien like :maSV \r\n"
//			+ "				  and lich.ngay_hoc BETWEEN :ngayBD AND :ngayKT", nativeQuery = true)
	@Query(value = "SELECT lich.*\r\n"
			+ "FROM     sinh_vien INNER JOIN\r\n"
			+ "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
			+ "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
			+ "                  lich ON nhom_thuc_hanh.ma_nhom = lich.ma_nhomth"
			+ "				  where sinh_vien.ma_sinh_vien like :maSV \r\n"
			+ "				  and lich.ngay_hoc BETWEEN :ngayBD AND :ngayKT", nativeQuery = true)
	public List<Lich> getLichTheoNgayCuaSinhVien(@Param("maSV") String maSV, @Param("ngayBD") String ngayBD, @Param("ngayKT") String ngayKT); 
	
	@Query(value = "SELECT ma_nhomth,MAX(ma_lich), MAX(ngay_hoc),MAX(ma_ca_hoc), MAX(ma_phong),MAX(id_nhan_vien)\r\n"
			+ " FROM lich \r\n"
			+ " WHERE ma_lop_hoc_phan like :maLopHocPhan\r\n"
			+ " GROUP BY ma_nhomth", nativeQuery = true)
	  List<Lich> getChiTietLopHPByMaLopHocPhan(@Param("maLopHocPhan") String maLopHocPhan);
	


}
