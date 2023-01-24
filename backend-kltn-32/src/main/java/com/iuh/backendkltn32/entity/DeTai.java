package com.iuh.backendkltn32.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Id
	private String maDeTai;
	
	@Column(name = "tenDeTai", nullable = false)
	private String tenDeTai;
	
	@Column(name = "mucTieuDeTai", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String mucTieuDeTai;
	
	@Column(name = "sanPhamDuKien", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String sanPhamDuKien;
	
	@Column(name = "moTa", columnDefinition = "nvarchar(255)")
	private String moTa;
	
	@Column(name = "yeuCauDauVao", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String yeuCauDauVao;
	
	@Column(name = "gioiHanSoNhomThucHien", nullable = false)
	private Integer gioiHanSoNhomThucHien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maGiangVien", nullable = false)
	private GiangVien giangVien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maLopHocPhan", nullable = false)
	private LopHocPhan lopHocPhan;

}
