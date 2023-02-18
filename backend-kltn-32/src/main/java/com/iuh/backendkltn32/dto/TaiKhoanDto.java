package com.iuh.backendkltn32.dto;


import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDto {

	private String tenTaiKhoan;
	private String password;
	private String role;

}
