package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.LopDanhNghia;
import com.iuh.backendkltn32.repository.LopDanhNghiaRepository;
import com.iuh.backendkltn32.service.LopDanhNghiaService;

@Service
public class LopDanhNghiaServiceImpl implements LopDanhNghiaService{
	
	@Autowired
	private LopDanhNghiaRepository repository;

	@Override
	public LopDanhNghia layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("LopDanhNghia service - layTheoMa: " + ma);
		LopDanhNghia lopDanhNghia = repository.findById(ma).orElse(null);

		return lopDanhNghia;
	}

	@Override
	public LopDanhNghia luu(LopDanhNghia obj) throws Exception {
		LopDanhNghia lopDanhNghiaDaTonTai = layTheoMa(obj.getMaLopDanhNghia());

		System.out.println("LopDanhNghia service - luu: " + lopDanhNghiaDaTonTai);

		if (lopDanhNghiaDaTonTai != null) {
			throw new RuntimeException("Lớp đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		LopDanhNghia lopDanhNghiaKhongTonTai = layTheoMa(ma);

		if (lopDanhNghiaKhongTonTai == null) {
			throw new RuntimeException("Lớp không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public LopDanhNghia capNhat(LopDanhNghia obj) throws Exception {
		LopDanhNghia lopDanhNghiaKhongTonTai = layTheoMa(obj.getMaLopDanhNghia());

		if (lopDanhNghiaKhongTonTai == null) {
			throw new RuntimeException("Lớp không tồn tại");
		}
		lopDanhNghiaKhongTonTai.setNamHoc(obj.getNamHoc());
		lopDanhNghiaKhongTonTai.setGioiHanSinhVien(obj.getGioiHanSinhVien());
		lopDanhNghiaKhongTonTai.setHocKy(obj.getHocKy());
		lopDanhNghiaKhongTonTai.setMoTa(obj.getMoTa());
		
		repository.save(lopDanhNghiaKhongTonTai);

		return lopDanhNghiaKhongTonTai;
	}

}
