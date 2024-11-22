package com.example.global_java.Repository;

import com.example.global_java.Entidade.PontuacoesQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontuacoesQuizRepository extends JpaRepository<PontuacoesQuiz, Long> {
}
