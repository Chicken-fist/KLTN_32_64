package com.iuh.backendkltn32.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "HocPhanKhoaLuanTotNghiep")
public class HocPhanKhoaLuanTotNghiep {
	
	@Id
	private String maHocPhan;
	private String tenHocPhan;
	private String soTinChi;
	private boolean hocPhantienQuyet;
	private HocKy hocKy;
}
