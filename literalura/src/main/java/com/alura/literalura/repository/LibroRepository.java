package com.alura.literalura.repository;


import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
//    Optional<Libro> findByTituloContainsIgnoreCase(String nombreLibro);
//
//    List<Libro> findTop5ByOrderByEvaluacionDesc();

    //List<Libro> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);


}
