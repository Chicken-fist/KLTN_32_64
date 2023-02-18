package com.iuh.backendkltn32.entity;


import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuh.backendkltn32.common.EVaiTro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "TaiKhoan")
public class TaiKhoan{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tenTaiKhoan")
	private String tenTaiKhoan;
	
	@Column(name = "password", columnDefinition = "varchar(255)" ,nullable = false)
	private String password = "1111";
	
	@OneToOne
	@JoinColumn(name = "vaiTro", referencedColumnName = "maVaiTro")
	private VaiTro vaiTro;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@MapsId
//	@JoinColumn(name = "tenTaiKhoan")
//	private GiangVien giangVien;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@MapsId
//	@JoinColumn(name = "tenTaiKhoan")
//	private SinhVien sinhVien;


}
