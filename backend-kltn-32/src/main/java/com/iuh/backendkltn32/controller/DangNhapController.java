package com.iuh.backendkltn32.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.backendkltn32.config.JwtService;
import com.iuh.backendkltn32.config.UserInfoUserDetails;
import com.iuh.backendkltn32.dto.JwtResponse;
import com.iuh.backendkltn32.dto.LoginRequest;
import com.iuh.backendkltn32.entity.TaiKhoan;
import com.iuh.backendkltn32.service.AbstractService;

@RestController
@RequestMapping("/api/xac-thuc")
public class DangNhapController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AbstractService<TaiKhoan> taiKhoanService;

	@PostMapping("/dang-nhap")
	public ResponseEntity<?> dangNhap(@Validated @RequestBody LoginRequest loginRequest) {
		String tenTaiKhoan = loginRequest.getTenTaiKhoan();
		// Xác thực từ username và password.
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(tenTaiKhoan, loginRequest.getPassword()));

		System.out.println("DangNhapController-dangNhap- " + loginRequest.getTenTaiKhoan());

		if (authentication.isAuthenticated()) {
			try {
				TaiKhoan taiKhoan = taiKhoanService.layTheoMa(loginRequest.getTenTaiKhoan());
				
				System.out.println("dangNhap controller - " + taiKhoan.getVaiTro().getTenVaiTro());
				
				String jwtToken = jwtService.generateToken(new UserInfoUserDetails(taiKhoan));

				return ResponseEntity
						.ok(new JwtResponse(jwtToken, "Bearer ", taiKhoan.getTenTaiKhoan(), taiKhoan.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
		return null;

	}

	@PostMapping("/test")
	public ResponseEntity<?> test(@Validated @RequestBody LoginRequest loginRequest) {

		System.out.println("xxxx" + loginRequest.getTenTaiKhoan() + "XXX");
		

		try {
			TaiKhoan taiKhoan = taiKhoanService.layTheoMa(loginRequest.getTenTaiKhoan());
			
			System.out.println("DangNhapController-test- " + encoder.encode(loginRequest.getPassword()));

			if(taiKhoan.getTenTaiKhoan().equals(loginRequest.getTenTaiKhoan()) && taiKhoan.getPassword().equals(encoder.encode(loginRequest.getPassword()))) {
				
				
				String jwtToken = jwtService.generateToken(new UserInfoUserDetails(taiKhoan));

				return ResponseEntity
						.ok(new JwtResponse(jwtToken, "Bearer", loginRequest.getTenTaiKhoan(), loginRequest.getPassword()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
