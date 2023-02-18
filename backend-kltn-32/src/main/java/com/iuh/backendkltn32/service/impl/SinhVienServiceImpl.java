package com.iuh.backendkltn32.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.SinhVien;
import com.iuh.backendkltn32.repository.SinhVienRepository;
import com.iuh.backendkltn32.service.SinhVienService;

import jakarta.transaction.Transactional;

@Service
public class SinhVienServiceImpl implements  SinhVienService {

	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public SinhVien layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("sinh vien service - layTheoMa: " + ma);
		SinhVien sinhVien =  sinhVienRepository.findById(ma).orElse(null);
		
		return sinhVien;
	}

	@Override
	@Transactional
	public SinhVien luu(SinhVien obj) throws Exception {

		SinhVien sinhVienDaTonTai = layTheoMa(obj.getMaSinhVien());
		
		System.out.println("sinh vien service - luu: " + sinhVienDaTonTai);

		if (sinhVienDaTonTai != null) {
			throw new RuntimeException("Sinh Viên đã tồn tại");
		}
		sinhVienRepository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {

		SinhVien sinhVienKhongTonTai = layTheoMa(ma);

		if (sinhVienKhongTonTai == null) {
			throw new RuntimeException("Sinh Viên không tồn tại");
		}
		sinhVienRepository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public SinhVien capNhat(SinhVien obj) throws Exception  {

		SinhVien sinhVienCanCapNhat = layTheoMa(obj.getMaSinhVien());

		if (sinhVienCanCapNhat == null) {
			throw new RuntimeException("Sinh Viên không tồn tại");
		}
		sinhVienCanCapNhat.setDienThoai(obj.getDienThoai());
		sinhVienCanCapNhat.setEmail(obj.getEmail());
		sinhVienCanCapNhat.setGioiTinh(obj.getGioiTinh());
		sinhVienCanCapNhat.setLopDanhNghia(obj.getLopDanhNghia());
		sinhVienCanCapNhat.setLopHocPhan(obj.getLopHocPhan());
		sinhVienCanCapNhat.setDsKetQua(obj.getDsKetQua());
		sinhVienCanCapNhat.setNamNhapHoc(obj.getNamNhapHoc());
		sinhVienCanCapNhat.setNgaySinh(obj.getNgaySinh());
		sinhVienCanCapNhat.setNhom(obj.getNhom());
		sinhVienCanCapNhat.setNoiSinh(obj.getNoiSinh());
		sinhVienCanCapNhat.setTenSinhVien(obj.getTenSinhVien());
		
		sinhVienRepository.save(sinhVienCanCapNhat);

		return sinhVienCanCapNhat;
	}

}
