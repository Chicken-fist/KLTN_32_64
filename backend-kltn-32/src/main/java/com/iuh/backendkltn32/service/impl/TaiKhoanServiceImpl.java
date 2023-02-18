package com.iuh.backendkltn32.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.TaiKhoan;
import com.iuh.backendkltn32.repository.TaiKhoanRepository;
import com.iuh.backendkltn32.service.TaiKhoanService;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{

	@Autowired
	private TaiKhoanRepository repository;
	
	@Override
	public TaiKhoan layTheoMa(String ma) {
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Tên tài khoản rỗng không được phép rỗng");
		}
		
		System.out.println("TaiKhoan service - layTheoMa: " + ma);
		
		TaiKhoan taiKhoan = repository.findByTenTaiKhoan(ma).orElse(null);
		
		return taiKhoan;
		
	}

	@Override
	public TaiKhoan luu(TaiKhoan obj) throws Exception  {
		
		TaiKhoan taiKhoanDaTonTai = layTheoMa(obj.getTenTaiKhoan());
		
		System.out.println("TaiKhoan service - luu: " + taiKhoanDaTonTai);

		if (taiKhoanDaTonTai != null) {
			throw new RuntimeException("Tài Khoản đã tồn tại");
		}
		repository.save(obj);

		return obj;
	}

	@Override
	public String xoa(String ma) throws Exception  {
		
		TaiKhoan taiKhoanChuaTonTai = layTheoMa(ma);

		if (taiKhoanChuaTonTai == null) {
			throw new RuntimeException("Tài khoản này không tồn tại");
		}
		repository.deleteById(ma);

		return "Xóa thành công";
	}

	@Override
	public TaiKhoan capNhat(TaiKhoan obj) throws Exception  {
		TaiKhoan taiKhoanChuaTonTai = layTheoMa(obj.getTenTaiKhoan());

		if (taiKhoanChuaTonTai == null) {
			throw new RuntimeException("Tài khoản này không tồn tại");
		}
		repository.save(obj);

		return obj;
	}



}
