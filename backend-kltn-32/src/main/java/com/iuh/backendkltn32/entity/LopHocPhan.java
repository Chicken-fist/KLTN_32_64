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
@Table(name = "LopHocPhan")
public class LopHocPhan {
	
	private String maLopHocPhan;
	private String tenLopHocPhan;
	private Date thoiGianBatDau;
	private Date thoiGianKetThuc;
	private String phong;
	private String ghiChu;

}
