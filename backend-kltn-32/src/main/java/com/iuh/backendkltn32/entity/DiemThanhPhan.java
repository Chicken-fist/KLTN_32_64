package com.iuh.backendkltn32.entity;

import java.util.Date;

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
@Table(name = "DiemThanhPhan")
public class DiemThanhPhan {

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maPhieu", nullable = false)
	private PhieuCham phieuCham;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maChuanDauRa", nullable = false)
	private TieuChiChamDiem tieuChiChamDiem;
	
	@Column(name = "diemThanhPhan", nullable = false)
	private String diemThanhPhan;
}
