package com.iuh.backendkltn32.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SinhVien")
public class SinhVien {
	
	private String maSinhVien;
	private String tenSinhVien;
	private String noiSinh;
	private String dienThoai;
	private String email;
	private Date ngaySinh;
	private Integer namNhapHoc;
	private Integer gioiTinh;

}
