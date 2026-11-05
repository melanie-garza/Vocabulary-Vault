package com.melanie.vocabvault.repository;

import com.melanie.vocabvault.model.VocabWord;
import com.melanie.vocabvault.model.TargetLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabWordRepository extends JpaRepository<VocabWord, Long> {
    List<VocabWord> findByTargetLevel(TargetLevel targetLevel);

    // SQL Nativo para obtener una palabra aleatoria general
    @Query(value = "SELECT * FROM vocabulary ORDER BY RAND() LIMIT 1", nativeQuery = true)
    VocabWord findRandomWord();

    // SQL Nativo para obtener una palabra aleatoria de un nivel específico
    @Query(value = "SELECT * FROM vocabulary WHERE target_level = :level ORDER BY RAND() LIMIT 1", nativeQuery = true)
    VocabWord findRandomWordByLevel(@Param("level") String level);
}