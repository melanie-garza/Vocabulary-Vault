package com.melanie.vocabvault.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vocabulary")
public class VocabWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String englishTerm;
    
    private String spanishTranslation;
    
    @Column(length = 500)
    private String definition; // Nuevo campo
    
    private String synonyms; // Nuevo campo

    private String partOfSpeech; 
    
    @Column(length = 500)
    private String exampleSentence;

    @Enumerated(EnumType.STRING)
    private TargetLevel targetLevel;

    public VocabWord() {}

    public VocabWord(String englishTerm, String spanishTranslation, String definition, String synonyms, String partOfSpeech, String exampleSentence, TargetLevel targetLevel) {
        this.englishTerm = englishTerm;
        this.spanishTranslation = spanishTranslation;
        this.definition = definition;
        this.synonyms = synonyms;
        this.partOfSpeech = partOfSpeech;
        this.exampleSentence = exampleSentence;
        this.targetLevel = targetLevel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEnglishTerm() { return englishTerm; }
    public void setEnglishTerm(String englishTerm) { this.englishTerm = englishTerm; }
    
    public String getSpanishTranslation() { return spanishTranslation; }
    public void setSpanishTranslation(String spanishTranslation) { this.spanishTranslation = spanishTranslation; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public String getSynonyms() { return synonyms; }
    public void setSynonyms(String synonyms) { this.synonyms = synonyms; }
    
    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }
    
    public String getExampleSentence() { return exampleSentence; }
    public void setExampleSentence(String exampleSentence) { this.exampleSentence = exampleSentence; }
    
    public TargetLevel getTargetLevel() { return targetLevel; }
    public void setTargetLevel(TargetLevel targetLevel) { this.targetLevel = targetLevel; }
}