package com.relatorios.demo.repository;

import com.relatorios.demo.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
}
