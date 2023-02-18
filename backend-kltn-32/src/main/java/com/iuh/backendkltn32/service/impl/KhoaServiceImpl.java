package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.Khoa;
import com.iuh.backendkltn32.repository.KhoaRepository;
import com.iuh.backendkltn32.service.KhoaService;

@Service
public class KhoaServiceImpl implements KhoaService{
	
	@Autowired
	private KhoaRepository repository;

	@Override
	public Khoa layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("Khoa service - layTheoMa: " + ma);
		Khoa khoa = repository.findById(ma).orElse(null);

		return khoa;
	}

	@Override
	public Khoa luu(Khoa obj) throws Exception {
		Khoa khoaDaTonTai = layTheoMa(obj.getMaKhoa());

		System.out.println("Khoa service - luu: " + khoaDaTonTai);

		if (khoaDaTonTai != null) {
			throw new RuntimeException("Khoa đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		Khoa khoaKhongTonTai = layTheoMa(ma);

		if (khoaKhongTonTai == null) {
			throw new RuntimeException("Khoa không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public Khoa capNhat(Khoa obj) throws Exception {
		Khoa khoaKhongTonTai = layTheoMa(obj.getMaKhoa());

		if (khoaKhongTonTai == null) {
			throw new RuntimeException("Khoa không tồn tại");
		}
		khoaKhongTonTai.setTenKhoa(obj.getTenKhoa());
		
		repository.save(khoaKhongTonTai);

		return khoaKhongTonTai;
	}

}
