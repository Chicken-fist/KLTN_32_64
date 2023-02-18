package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.LopHocPhan;
import com.iuh.backendkltn32.repository.LopHocPhanRepository;
import com.iuh.backendkltn32.service.LopHocPhanService;

@Service
public class LopHocPhanServiceImpl implements LopHocPhanService {

	@Autowired
	private LopHocPhanRepository repository;

	@Override
	public LopHocPhan layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("LopHocPhan service - layTheoMa: " + ma);
		LopHocPhan lopHocPhan = repository.findById(ma).orElse(null);

		return lopHocPhan;
	}

	@Override
	public LopHocPhan luu(LopHocPhan obj) throws Exception {
		LopHocPhan lopHocPhanDaTonTai = layTheoMa(obj.getMaLopHocPhan());

		System.out.println("LopHocPhan service - luu: " + lopHocPhanDaTonTai);

		if (lopHocPhanDaTonTai != null) {
			throw new RuntimeException("Lớp Học Phần đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		LopHocPhan lopHocPhanKhongTonTai = layTheoMa(ma);

		if (lopHocPhanKhongTonTai == null) {
			throw new RuntimeException("Lớp Học phần không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public LopHocPhan capNhat(LopHocPhan obj) throws Exception {
		LopHocPhan lopHocPhanKhongTonTai = layTheoMa(obj.getMaLopHocPhan());

		if (lopHocPhanKhongTonTai == null) {
			throw new RuntimeException("Lớp Học phần không tồn tại");
		}
		lopHocPhanKhongTonTai.setGhiChu(obj.getGhiChu());
		lopHocPhanKhongTonTai.setHocPhanKhoaLuanTotNghiep(obj.getHocPhanKhoaLuanTotNghiep());
		lopHocPhanKhongTonTai.setPhong(obj.getPhong());
		lopHocPhanKhongTonTai.setTenLopHocPhan(obj.getTenLopHocPhan());
		lopHocPhanKhongTonTai.setThoiGianBatDau(obj.getThoiGianBatDau());
		lopHocPhanKhongTonTai.setThoiGianKetThuc(obj.getThoiGianKetThuc());

		repository.save(lopHocPhanKhongTonTai);

		return lopHocPhanKhongTonTai;
	}

}
