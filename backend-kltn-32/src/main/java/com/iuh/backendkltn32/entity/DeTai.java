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
@Table(name = "DeTai")
public class DeTai {
	
	private String maDeTai;
	private String tenDeTai;
	private String mucTieuDeTai;
	private String sanPhamDuKien;
	private String moTa;
	private String yeuCauDauVao;
	private Integer gioiHanSoNhomThucHien;

}
