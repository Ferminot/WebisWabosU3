package com.webis.webis_backend.repository;

import com.webis.webis_backend.model.Maceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacetaRepository extends JpaRepository<Maceta, Long> {
}
