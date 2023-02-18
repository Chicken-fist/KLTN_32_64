package com.iuh.backendkltn32.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.iuh.backendkltn32.entity.TaiKhoan;
import com.iuh.backendkltn32.repository.TaiKhoanRepository;


/*
 * class dung de hieu chinh cac 1 vai thu can thiet cho tai khoan
 * co the su dung jwt
 */
@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private TaiKhoanRepository repository;

	@Override
	public UserDetails loadUserByUsername(String tenTaiKhoan) throws UsernameNotFoundException {

		Optional<TaiKhoan> userInfo = repository.findByTenTaiKhoan(tenTaiKhoan);
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + tenTaiKhoan));
	}

}
