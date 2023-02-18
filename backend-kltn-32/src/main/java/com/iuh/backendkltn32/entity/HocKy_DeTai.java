package com.iuh.backendkltn32.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "HocKy_DeTai")
public class HocKy_DeTai {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maHocKy", nullable = false)
	private HocKy hocKy;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maDeTai", nullable = false)
	private DeTai deTai;
	
	@Column(name = "soLanSuDung", nullable = false)
	private int soLanSuDung;

}
