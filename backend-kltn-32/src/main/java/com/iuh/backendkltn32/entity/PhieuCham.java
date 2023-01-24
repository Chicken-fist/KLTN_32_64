package com.iuh.backendkltn32.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name = "PhieuCham")
public class PhieuCham {
	
	@Id
	private String maPhieu;
	
	@Column(name = "tenPhieu", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String tenPhieu;
	
	@Column(name = "diemPhieuCham", nullable = false)
	private Double diemPhieuCham;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuCham")
	private List<KetQua> dsKetQua;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuCham")
	private List<DiemThanhPhan> dsDiemThanhPhan;

}
