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
@Table(name = "Nhom")
public class Nhom {
	
	@Id
	private String maNhom;
	
	@Column(name = "tenNhom", columnDefinition = "nvarchar(255)", nullable = false)
	private String tenNhom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maDeTai", nullable = false)
	private DeTai deTai;
	

}
