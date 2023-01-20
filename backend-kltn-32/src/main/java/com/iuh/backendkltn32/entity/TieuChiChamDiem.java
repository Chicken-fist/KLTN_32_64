package com.iuh.backendkltn32.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private String tenChuanDauRa;

}
