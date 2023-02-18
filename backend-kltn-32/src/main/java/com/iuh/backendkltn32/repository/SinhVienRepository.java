package com.iuh.backendkltn32.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.backendkltn32.entity.HocKy;
import com.iuh.backendkltn32.entity.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>{

	Optional<SinhVien> findByMaSinhVien(String maSinhVien);
}
