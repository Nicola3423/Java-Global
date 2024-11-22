package com.example.global_java.Repository;

import com.example.global_java.Entidade.DicasEconomia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DicasEconomiaRepository extends JpaRepository<DicasEconomia, Long> {
}
