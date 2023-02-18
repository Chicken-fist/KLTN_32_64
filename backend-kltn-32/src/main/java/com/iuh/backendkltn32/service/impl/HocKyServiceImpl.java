package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.HocKy;
import com.iuh.backendkltn32.repository.HocKyRepository;
import com.iuh.backendkltn32.service.HocKyService;

@Service
public class HocKyServiceImpl implements HocKyService{
	
	@Autowired
	private HocKyRepository repository;

	@Override
	public HocKy layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("HocKy service - layTheoMa: " + ma);
		HocKy hocKy = repository.findById(ma).orElse(null);

		return hocKy;
	}

	@Override
	public HocKy luu(HocKy obj) throws Exception {
		HocKy hocKyDaTonTai = layTheoMa(obj.getMaHocKy());

		System.out.println("HocKy service - luu: " + hocKyDaTonTai);

		if (hocKyDaTonTai != null) {
			throw new RuntimeException("Học kỳ đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		HocKy hocKyKhongTonTai = layTheoMa(ma);

		if (hocKyKhongTonTai == null) {
			throw new RuntimeException("Học Kỳ không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public HocKy capNhat(HocKy obj) throws Exception {
		HocKy hocKyKhongTonTai = layTheoMa(obj.getMaHocKy());

		if (hocKyKhongTonTai == null) {
			throw new RuntimeException("Học kỳ không tồn tại");
		}
		hocKyKhongTonTai.setNamHoc(obj.getNamHoc());
		
		repository.save(hocKyKhongTonTai);

		return hocKyKhongTonTai;
	}
	
	


}
