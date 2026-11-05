package com.melanie.vocabvault.controller;

import com.melanie.vocabvault.model.VocabWord;
import com.melanie.vocabvault.model.TargetLevel;
import com.melanie.vocabvault.repository.VocabWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vocab")
public class VocabController {

    @Autowired
    private VocabWordRepository repository;

    @GetMapping
    public List<VocabWord> getAllWords() {
        return repository.findAll();
    }

    @GetMapping("/level/{level}")
    public List<VocabWord> getWordsByLevel(@PathVariable TargetLevel level) {
        return repository.findByTargetLevel(level);
    }

    @PostMapping
    public VocabWord addWord(@RequestBody VocabWord newWord) {
        return repository.save(newWord);
    }

    // --- RUTAS NUEVAS PARA EL RANDOM ---
    
    @GetMapping("/random")
    public VocabWord getRandomWord() {
        return repository.findRandomWord();
    }

    @GetMapping("/random/{level}")
    public VocabWord getRandomWordByLevel(@PathVariable TargetLevel level) {
        // Pasamos el nivel como String (name) porque la consulta SQL nativa lo espera así
        return repository.findRandomWordByLevel(level.name());
    }
}