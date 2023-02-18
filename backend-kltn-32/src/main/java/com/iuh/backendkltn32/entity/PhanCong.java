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
@Table(name = "PhanCong")
public class PhanCong {
	
	@Id
	private String maPhanCong;
	
	@Column(name = "viTriPhanCong", columnDefinition = "nvarchar(255)", nullable = false)
	private String viTriPhanCong;
	
	@Column(name = "chamCong",nullable = false)
	private Boolean chamCong;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maNhom", nullable = false)
	private Nhom nhom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maGiangVien", nullable = false)
	private GiangVien giangVien;

}
