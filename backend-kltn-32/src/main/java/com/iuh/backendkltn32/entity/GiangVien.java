package com.iuh.backendkltn32.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "GiangVien")
public class GiangVien {
	
	@Id
	private String maGiangVien;
	
	@Column(name = "tenGiangVien", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String tenGiangVien;
	
	@Column(name = "soDienThoai", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String soDienThoai;
	
	@Column(name = "email", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String email;
	
	@Column(name = "cmnd", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String cmnd;
	
	@Column(name = "hocVi", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String hocVi;
	
	@Column(name = "ngaySinh")
	private Date ngaySinh;
	
	@Column(name = "namCongTac", nullable = false)
	private Integer namCongTac;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maKhoa", nullable = false)
	private Khoa khoa;
	
	@Column(name = "gioiTinh", nullable = false)
	private Integer gioiTinh;
	
//	@OneToOne( mappedBy = "giangVien")
//	@JsonIgnore
//	private TaiKhoan taiKhoan;
	

}
