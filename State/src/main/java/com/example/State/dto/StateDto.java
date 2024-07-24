package com.example.State.dto;

public class StateDto {
    private Long id;
    private String name;
    private String abbreviation;
    private String capital;

    // Constructors, getters, setters
    // Add additional fields as needed

    public void StateDTO() {
        // Default constructor
    }

    public void StateDTO(String name, String abbreviation, String capital) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.capital = capital;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}

