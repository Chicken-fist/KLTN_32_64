package com.iuh.backendkltn32.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.backendkltn32.dto.LoginRequest;
import com.iuh.backendkltn32.entity.SinhVien;
import com.iuh.backendkltn32.entity.TaiKhoan;
import com.iuh.backendkltn32.service.SinhVienService;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {

	@Autowired
	private SinhVienService sinhVienService;

	@GetMapping("/thong-tin-ca-nhan/{maSinhVien}")
	@PreAuthorize("hasAuthority('ROLE_SINHVIEN')")
	public SinhVien hienThiThongTinCaNhan(@PathVariable String maSinhVien, @RequestBody LoginRequest loginRequest) {
		try {
			if (!loginRequest.getTenTaiKhoan().equals(maSinhVien)) {
				throw new Exception("Khong Dung Ma Sinh Vien");
			}
			SinhVien sinhVien = sinhVienService.layTheoMa(maSinhVien);

			return sinhVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
