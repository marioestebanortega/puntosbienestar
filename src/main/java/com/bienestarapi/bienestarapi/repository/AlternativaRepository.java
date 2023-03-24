package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer>{

    Optional<Alternativa> findByIdalternativa(Long idalternativa);
    Optional<Alternativa> findByNombre(String nombre);

}
