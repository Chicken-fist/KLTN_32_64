package com.iuh.backendkltn32.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
public class TaiKhoan {
	
	@Id
	@Column(name = "tenTaiKhoan")
	private String tenTaiKhoan;
	
	@Column(name = "password", columnDefinition = "varchar(255)" ,nullable = false)
	private String password = "1111";
	
	@OneToOne
	@JoinColumn(name = "vaiTro", referencedColumnName = "maVaiTro")
	private VaiTro vaiTro;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "tenTaiKhoan")
	private SinhVien sinhVien;

}
