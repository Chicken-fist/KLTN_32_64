package com.iuh.backendkltn32.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.backendkltn32.dto.LoginRequest;
import com.iuh.backendkltn32.entity.DeTai;
import com.iuh.backendkltn32.entity.GiangVien;
import com.iuh.backendkltn32.entity.SinhVien;
import com.iuh.backendkltn32.service.DeTaiService;
import com.iuh.backendkltn32.service.GiangVienService;

@RestController
@RequestMapping("/api/giang-vien")
public class GiangVienController {
	
	@Autowired
	private DeTaiService deTaiService;
	
	@Autowired
	private GiangVienService giangVienService;
	
	@GetMapping("/thong-tin-ca-nhan/{maGiangVien}")
	@PreAuthorize("hasAuthority('ROLE_GIANGVIEN')")
	public GiangVien hienThiThongTinCaNhan(@PathVariable String maGiangVien, @RequestBody LoginRequest loginRequest) {
		try {
			if (!loginRequest.getTenTaiKhoan().equals(maGiangVien)) {
				throw new Exception("Khong Dung Ma Sinh Vien");
			}
			GiangVien giangVien = giangVienService.layTheoMa(maGiangVien);

			return giangVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/them-de-tai")
	@PreAuthorize("hasAuthority('ROLE_GIANGVIEN') or hasAuthority('ROLE_QUANLY')")
	public DeTai themDeTai(@RequestBody DeTai deTai) {
		
		try {
			DeTai ketQuaLuu = deTaiService.luu(deTai);
			
			return ketQuaLuu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@DeleteMapping("/sua-de-tai/{maDeTai}")
	@PreAuthorize("hasAuthority('ROLE_GIANGVIEN') or hasAuthority('ROLE_QUANLY')")
	public String xoaDeTai(@PathVariable String maDeTai) {
		
		try {
			String ketQuaXoaDeTai = deTaiService.xoa(maDeTai);
			
			return ketQuaXoaDeTai;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping("/xoa-de-tai")
	@PreAuthorize("hasAuthority('ROLE_GIANGVIEN') or hasAuthority('ROLE_QUANLY')")
	public DeTai suaDeTai(@RequestBody DeTai deTai) {
		
		try {
			DeTai ketQuaLuu = deTaiService.capNhat(deTai);
			
			return ketQuaLuu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
