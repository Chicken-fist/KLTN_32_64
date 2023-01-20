package com.iuh.backendkltn32.entity;

import jakarta.persistence.Entity;
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
	
	private Long maVaiTro;
	private String tenVaiTro;

}
