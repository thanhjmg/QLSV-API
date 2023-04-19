package com.kltn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.BangDiem;

public interface BangDiemRepository extends JpaRepository<BangDiem, String>{
	@Query(value = "SELECT distinct bang_diem.*\r\n"
			+ "FROM     lop_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_phan ON lop_hoc_phan.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  bang_diem ON hoc_phan.ma_hoc_phan = bang_diem.ma_hoc_phan\r\n"
			+ "				  where lop_hoc_phan.ma_lop_hoc_phan like :maLHP", nativeQuery = true)
	public List<BangDiem> getbangDiemTheoLHP(@Param("maLHP") String maLHP);
	
	
	@Query(value = "SELECT DISTINCT \r\n"
			+ "                  bang_diem.* \r\n"
			+ "FROM     sinh_vien INNER JOIN\r\n"
			+ "                  bang_diem ON sinh_vien.ma_sinh_vien = bang_diem.ma_sinh_vien INNER JOIN\r\n"
			+ "                  hoc_phan ON bang_diem.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
			+ "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
			+ "                  lop_hoc_phan ON hoc_phan.ma_hoc_phan = lop_hoc_phan.ma_hoc_phan AND nhom_thuc_hanh.ma_lop_hoc_phan = lop_hoc_phan.ma_lop_hoc_phan INNER JOIN\r\n"
			+ "                  phieu_dang_ky_hoc_phan AS phieu_dang_ky_hoc_phan_1 ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan_1.id_sinh_vien AND chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp = phieu_dang_ky_hoc_phan_1.ma_phieu_dang_ky where sinh_vien.ma_sinh_vien like :maSinhVien AND phieu_dang_ky_hoc_phan.ma_hoc_ky LIKE :maHK", nativeQuery = true)
	public List<BangDiem> getBangDiemBySVAndHK (@Param("maSinhVien") String maSinhVien,@Param("maHK") String maHK);
	
	
	@Query(value = "SELECT AVG( DISTINCT bang_diem.diem_tong_ket) \r\n"
			+ "FROM     bang_diem INNER JOIN\r\n"
			+ "                  sinh_vien ON bang_diem.ma_sinh_vien = sinh_vien.ma_sinh_vien INNER JOIN\r\n"
			+ "                  hoc_phan ON bang_diem.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
			+ "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
			+ "                  lop_hoc_phan ON hoc_phan.ma_hoc_phan = lop_hoc_phan.ma_hoc_phan AND nhom_thuc_hanh.ma_lop_hoc_phan = lop_hoc_phan.ma_lop_hoc_phan INNER JOIN\r\n"
			+ "                  chi_tiet_hoc_phan ON hoc_phan.ma_hoc_phan = chi_tiet_hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  hoc_ky ON phieu_dang_ky_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky AND chi_tiet_hoc_phan.ma_hoc_ky = hoc_ky.ma_hoc_ky where sinh_vien.ma_sinh_vien like :maSinhVien AND hoc_ky.ma_hoc_ky LIKE :maHK", nativeQuery = true)
	public float diemTBTheoHK(@Param("maSinhVien") String maSinhVien,@Param("maHK") String maHK);
	
	@Query(value = "SELECT DISTINCT \r\n"
			+ "                  bang_diem.*"
			+ "FROM     sinh_vien INNER JOIN\r\n"
			+ "                  bang_diem ON sinh_vien.ma_sinh_vien = bang_diem.ma_sinh_vien INNER JOIN\r\n"
			+ "                  hoc_phan ON bang_diem.ma_hoc_phan = hoc_phan.ma_hoc_phan INNER JOIN\r\n"
			+ "                  phieu_dang_ky_hoc_phan ON sinh_vien.ma_sinh_vien = phieu_dang_ky_hoc_phan.id_sinh_vien INNER JOIN\r\n"
			+ "                  chi_tiet_phieu_dang_ky ON phieu_dang_ky_hoc_phan.ma_phieu_dang_ky = chi_tiet_phieu_dang_ky.ma_phieu_dang_kyhp INNER JOIN\r\n"
			+ "                  nhom_thuc_hanh ON chi_tiet_phieu_dang_ky.ma_nhomth = nhom_thuc_hanh.ma_nhom INNER JOIN\r\n"
			+ "                  lop_hoc_phan ON hoc_phan.ma_hoc_phan = lop_hoc_phan.ma_hoc_phan AND nhom_thuc_hanh.ma_lop_hoc_phan = lop_hoc_phan.ma_lop_hoc_phan where sinh_vien.ma_sinh_vien like :maSinhVien and bang_diem.trang_thai like N'Không đạt'", nativeQuery = true)
	public List<BangDiem> getBangDiemKhongDat(@Param("maSinhVien") String maSinhVien);
	
	@Query("SELECT COUNT(*) val_count FROM BangDiem")
	public int autoId();
}
