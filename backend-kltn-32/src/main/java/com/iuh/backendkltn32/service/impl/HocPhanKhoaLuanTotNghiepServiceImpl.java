package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.HocPhanKhoaLuanTotNghiep;
import com.iuh.backendkltn32.repository.HocPhanKhoaLuanTotNghiepRepository;
import com.iuh.backendkltn32.service.HocPhanKhoaLuanTotNghiepService;

@Service
public class HocPhanKhoaLuanTotNghiepServiceImpl implements HocPhanKhoaLuanTotNghiepService {
	
	@Autowired
	private HocPhanKhoaLuanTotNghiepRepository repository;

	@Override
	public HocPhanKhoaLuanTotNghiep layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("HocPhanKhoaLuanTotNghiep service - layTheoMa: " + ma);
		HocPhanKhoaLuanTotNghiep hocPhanKhoaLuanTotNghiep = repository.findById(ma).orElse(null);

		return hocPhanKhoaLuanTotNghiep;
	}

	@Override
	public HocPhanKhoaLuanTotNghiep luu(HocPhanKhoaLuanTotNghiep obj) throws Exception {
		HocPhanKhoaLuanTotNghiep hocPhanKhoaLuanTotNghiepDaTonTai = layTheoMa(obj.getMaHocPhan());

		System.out.println("HocPhanKhoaLuanTotNghiep service - luu: " + hocPhanKhoaLuanTotNghiepDaTonTai);

		if (hocPhanKhoaLuanTotNghiepDaTonTai != null) {
			throw new RuntimeException("Học Phần đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		HocPhanKhoaLuanTotNghiep hocPhanKhoaLuanTotNghiepKhongTonTai = layTheoMa(ma);

		if (hocPhanKhoaLuanTotNghiepKhongTonTai == null) {
			throw new RuntimeException("Học Phần không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public HocPhanKhoaLuanTotNghiep capNhat(HocPhanKhoaLuanTotNghiep obj) throws Exception {
		HocPhanKhoaLuanTotNghiep hocPhanKhoaLuanTotNghiepKhongTonTai = layTheoMa(obj.getMaHocPhan());

		if (hocPhanKhoaLuanTotNghiepKhongTonTai == null) {
			throw new RuntimeException("Học Phần không tồn tại");
		}
		hocPhanKhoaLuanTotNghiepKhongTonTai.setHocKy(obj.getHocKy());
		hocPhanKhoaLuanTotNghiepKhongTonTai.setHocPhantienQuyet(obj.isHocPhantienQuyet());
		hocPhanKhoaLuanTotNghiepKhongTonTai.setSoTinChi(obj.getSoTinChi());
		hocPhanKhoaLuanTotNghiepKhongTonTai.setTenHocPhan(obj.getTenHocPhan());
		
		repository.save(hocPhanKhoaLuanTotNghiepKhongTonTai);

		return hocPhanKhoaLuanTotNghiepKhongTonTai;
	}

}
