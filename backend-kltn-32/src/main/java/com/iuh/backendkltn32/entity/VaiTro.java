package com.iuh.backendkltn32.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "VaiTro")
public class VaiTro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maVaiTro;
	
	@Column(name = "tenVaiTro", columnDefinition = "nvarchar(255)" ,nullable = false)
	private String tenVaiTro;
	

}
