package com.iuh.backendkltn32.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LopDanhNghia")
public class LopDanhNghia {
	
	private String namHoc;
	private Integer HocKy;
	private String maMon;
	private String moTa;
	private Integer gioiHanSinhVien;
}
