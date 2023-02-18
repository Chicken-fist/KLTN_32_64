package com.iuh.backendkltn32.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@Id
	private String maLopHocPhan;
	
	@Column(name = "tenLopHocPhan", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String tenLopHocPhan;
	
	@Column(name = "thoiGianBatDau", nullable = false)
	private Date thoiGianBatDau;
	
	@Column(name = "thoiGianKetThuc", nullable = false)
	private Date thoiGianKetThuc;
	
	@Column(name = "phong", nullable = false)
	private String phong;
	
	@Column(name = "ghiChu", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String ghiChu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maHocPhan", nullable = false)
	private HocPhanKhoaLuanTotNghiep hocPhanKhoaLuanTotNghiep;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lopHocPhan")
//	private List<SinhVien> dsSinhVien;

}
