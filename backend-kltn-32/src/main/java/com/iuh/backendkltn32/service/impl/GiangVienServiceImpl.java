/**
 * 
 */
package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.GiangVien;
import com.iuh.backendkltn32.repository.GiangVienRepository;
import com.iuh.backendkltn32.service.GiangVienService;

/**
 * @author Dang Nguyen
 *
 */
@Service
public class GiangVienServiceImpl implements GiangVienService {

	@Autowired
	private GiangVienRepository repository;

	@Override
	public GiangVien layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("Giangvien service - layTheoMa: " + ma);
		GiangVien giangVien = repository.findById(ma).orElse(null);

		return giangVien;
	}

	@Override
	public GiangVien luu(GiangVien obj) throws Exception {
		GiangVien giangVienDaTonTai = layTheoMa(obj.getMaGiangVien());

		System.out.println("Giangvien service - luu: " + giangVienDaTonTai);

		if (giangVienDaTonTai != null) {
			throw new RuntimeException("giảng Viên đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		GiangVien giangVienKhongTonTai = layTheoMa(ma);

		if (giangVienKhongTonTai == null) {
			throw new RuntimeException("giang Viên không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public GiangVien capNhat(GiangVien obj) throws Exception {
		GiangVien giangVienCanCapNhat = layTheoMa(obj.getMaGiangVien());

		if (giangVienCanCapNhat == null) {
			throw new RuntimeException("giang Viên không tồn tại");
		}
		giangVienCanCapNhat.setCmnd(obj.getCmnd());
		giangVienCanCapNhat.setEmail(obj.getEmail());
		giangVienCanCapNhat.setGioiTinh(obj.getGioiTinh());
		giangVienCanCapNhat.setHocVi(obj.getHocVi());
		giangVienCanCapNhat.setKhoa(obj.getKhoa());
		giangVienCanCapNhat.setNamCongTac(obj.getNamCongTac());
		giangVienCanCapNhat.setNgaySinh(obj.getNgaySinh());
		giangVienCanCapNhat.setSoDienThoai(obj.getSoDienThoai());
		giangVienCanCapNhat.setTenGiangVien(obj.getTenGiangVien());
		
		repository.save(giangVienCanCapNhat);

		return giangVienCanCapNhat;
	}

}
