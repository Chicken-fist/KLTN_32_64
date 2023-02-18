package com.iuh.backendkltn32.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.backendkltn32.common.EVaiTro;
import com.iuh.backendkltn32.dto.LoginRequest;
import com.iuh.backendkltn32.entity.GiangVien;
import com.iuh.backendkltn32.entity.Khoa;
import com.iuh.backendkltn32.entity.SinhVien;
import com.iuh.backendkltn32.entity.TaiKhoan;
import com.iuh.backendkltn32.entity.VaiTro;
import com.iuh.backendkltn32.service.GiangVienService;
import com.iuh.backendkltn32.service.KhoaService;
import com.iuh.backendkltn32.service.SinhVienService;
import com.iuh.backendkltn32.service.TaiKhoanService;
import com.iuh.backendkltn32.service.VaiTroService;

@RestController
@RequestMapping("/api/quan-ly")
public class QuanLyBoMonController {


	@Autowired
	private SinhVienService sinhVienService;
	
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@Autowired
	private VaiTroService vaiTroService;
	
	@Autowired
	private GiangVienService giangVienService;
	
	@Autowired
	private KhoaService khoaService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/thong-tin-ca-nhan/{maQuanLy}")
	@PreAuthorize("hasAuthority('ROLE_QUANLY')")
	public GiangVien hienThiThongTinCaNhan(@PathVariable String maQuanLy, @RequestBody LoginRequest loginRequest) {
		try {
			if (!loginRequest.getTenTaiKhoan().equals(maQuanLy)) {
				throw new Exception("Khong Dung Ma Giang Vien");
			}
			GiangVien giangVien = giangVienService.layTheoMa(maQuanLy);

			return giangVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/them-sinh-vien")
	@PreAuthorize("hasAuthority('ROLE_QUANLY')")
	public SinhVien themSinhVienVaoHeThong(@RequestBody SinhVien sinhVien) {
		
		try {
			SinhVien ketQuaLuuSinhVien = sinhVienService.luu(sinhVien);
			
			TaiKhoan taiKhoan = new TaiKhoan(sinhVien.getMaSinhVien(), encoder.encode("1111"), vaiTroService.layTheoMa(4L));
			
			taiKhoanService.luu(taiKhoan);
			return ketQuaLuuSinhVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@PostMapping("/them-giang-vien")
	@PreAuthorize("hasAuthority('ROLE_QUANLY')")
	public GiangVien themSGiangVienVaoHeThong(@RequestBody GiangVien giangVien) {
		
		try {
			Khoa khoa = khoaService.layTheoMa(giangVien.getKhoa().getMaKhoa());
			giangVien.setKhoa(khoa);
			GiangVien ketQuaLuuGiangVien = giangVienService.luu(giangVien);
			
			TaiKhoan taiKhoan = new TaiKhoan(giangVien.getMaGiangVien(), encoder.encode("1111"), vaiTroService.layTheoMa(3L));

			
			taiKhoanService.luu(taiKhoan);
			return ketQuaLuuGiangVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
}
