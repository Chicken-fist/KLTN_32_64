package com.iuh.backendkltn32.entity;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TieuChiChamDiem")
public class TieuChiChamDiem {
	
	@Id
	private String maChuanDauRa;
	
	@Column(name = "tenChuanDauRa", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String tenChuanDauRa;
	
	@Column(name = "diemToiDa", nullable = false)
	private Double diemToiDa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tieuChiChamDiem")
	private List<DiemThanhPhan> dsDiemThanhPhan;

}
