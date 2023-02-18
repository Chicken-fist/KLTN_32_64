package com.iuh.backendkltn32.entity;

import com.iuh.backendkltn32.common.EVaiTro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(name = "tenVaiTro", columnDefinition = "varchar(255)" ,nullable = false)
	@Enumerated(EnumType.STRING)
	private EVaiTro tenVaiTro;
	

}
