package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.Nhom;
import com.iuh.backendkltn32.repository.NhomRepository;
import com.iuh.backendkltn32.service.NhomService;

@Service
public class NhomServiceImpl implements NhomService{
	
	@Autowired
	private NhomRepository repository;
	

	@Override
	public Nhom layTheoMa(String ma) throws Exception {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Mã không được phép rỗng");
		}
		System.out.println("Nhom service - layTheoMa: " + ma);
		Nhom nhom = repository.findById(ma).orElse(null);

		return nhom;
	}

	@Override
	public Nhom luu(Nhom obj) throws Exception {
		Nhom nhomDaTonTai = layTheoMa(obj.getMaNhom());

		System.out.println("Nhom service - luu: " + nhomDaTonTai);

		if (nhomDaTonTai != null) {
			throw new RuntimeException("Nhóm đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception {
		Nhom nhomKhongTonTai = layTheoMa(ma);

		if (nhomKhongTonTai == null) {
			throw new RuntimeException("Nhóm không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public Nhom capNhat(Nhom obj) throws Exception {
		Nhom nhomKhongTonTai = layTheoMa(obj.getMaNhom());

		if (nhomKhongTonTai == null) {
			throw new RuntimeException("Nhóm không tồn tại");
		}
		nhomKhongTonTai.setDeTai(obj.getDeTai());
		nhomKhongTonTai.setTenNhom(obj.getTenNhom());
		
		repository.save(nhomKhongTonTai);

		return nhomKhongTonTai;
	}

}
