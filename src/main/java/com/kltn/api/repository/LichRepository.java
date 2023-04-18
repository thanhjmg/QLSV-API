package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.ChiTietHocPhan;
import com.kltn.api.entity.Lich;
import com.kltn.api.entity.MonHoc;

public interface LichRepository extends JpaRepository<Lich, String> {
	@Query("SELECT COUNT(*) val_count FROM Lich")
	public int autoId();
	
	//@Query(value = "select lich.* from lich where ma_lop_hoc_phan like :maLHP", nativeQuery = true)
	@Query(value = "SELECT lich.*\r\n"
			+ "FROM     lich INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON lich.ma_nhomth = nhom_thuc_hanh.ma_nhom\r\n"
			+ "				  where nhom_thuc_hanh.ma_lop_hoc_phan like :maLHP", nativeQuery = true)
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
	
	@Query("SELECT lich FROM Lich lich WHERE lower(lich.maLich) LIKE lower(concat('%', :valueSearch, '%'))")
	public List<Lich> getLichByTextSearch(@Param("valueSearch") String valueSearch);

	@Query(value =
	        
	         "SELECT lich.*\r\n"
	         + "FROM     chi_tiet_phieu_dang_ky INNER JOIN\r\n"
	         + "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
	         + "                  lich ON nhom_thuc_hanh.ma_nhom = lich.ma_nhomth INNER JOIN\r\n"
	         + "                  phieu_dang_ky_hoc_phan ON chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp = phieu_dang_ky_hoc_phan.ma_phieu_dang_ky INNER JOIN\r\n"
	         + "                  sinh_vien ON phieu_dang_ky_hoc_phan.id_sinh_vien = sinh_vien.ma_sinh_vien WHERE sinh_vien.ma_sinh_vien LIKE :maSinhVien AND nhom_thuc_hanh.ma_lop_hoc_phan LIKE :maLHP", nativeQuery = true)
	public List<Lich> getListChiTietPDKByMaSinhVienAndLopHP(@Param("maSinhVien") String maSinhVien,@Param("maLHP") String maLHP);
	
	@Query(value =       
	         "SELECT lich.*\r\n"
	         + "FROM     sinh_vien INNER JOIN\r\n"
	         + "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
	         + "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
	         + "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
	         + "                  lop_hoc_phan ON nhom_thuc_hanh.ma_lop_hoc_phan = lop_hoc_phan.ma_lop_hoc_phan INNER JOIN\r\n"
	         + "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
	         + "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan INNER JOIN\r\n"
	         + "                  hoc_ky ON phieu_dang_ky_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky AND chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky INNER JOIN\r\n"
	         + "                  lich ON nhom_thuc_hanh.ma_nhom = lich.ma_nhomth where sinh_vien.ma_sinh_vien like :maSinhVien AND hoc_ky.ma_hoc_ky like :maHK", nativeQuery = true)
	public List<Lich> getALLLichByMaSinhVienAndHK(@Param("maSinhVien") String maSinhVien,@Param("maHK") String maHK);
}
