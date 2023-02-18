package com.iuh.backendkltn32.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.backendkltn32.common.EVaiTro;
import com.iuh.backendkltn32.entity.HocKy;
import com.iuh.backendkltn32.entity.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long>{

	Optional<VaiTro> findByTenVaiTro(EVaiTro tenVaiTro);
}
