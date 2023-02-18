package com.iuh.backendkltn32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.backendkltn32.entity.VaiTro;
import com.iuh.backendkltn32.repository.VaiTroRepository;
import com.iuh.backendkltn32.service.VaiTroService;

@Service
public class VaiTroServiceImpl implements VaiTroService{
	
	@Autowired
	private VaiTroRepository repository;

	@Override
	public VaiTro layTheoMa(Long ma) throws Exception {
		
		if (ma == null || ma.equals("")) {
			throw new RuntimeException("Tên tài khoản rỗng không được phép rỗng");
		}
		
		System.out.println("VaiTro service - layTheoMa: " + ma);
		
		VaiTro vaiTro = repository.findById(ma).orElse(null);
		
		return vaiTro;
	}

	@Override
	public VaiTro layTheoMa(String ma) throws Exception {
		return null;
	}

	@Override
	public VaiTro luu(VaiTro obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xoa(String ma) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaiTro capNhat(VaiTro obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
