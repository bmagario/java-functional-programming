package com.bmagario.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sommelier {

    private String name;
    private String expertise;
    private int age;
    private boolean hasWonAward;
    private String country;
    private List<Wine> wines;

    public Sommelier(String name, String expertise, int age, boolean hasWonAward, String country) {
        this.name = name;
        this.expertise = expertise;
        this.age = age;
        this.hasWonAward = hasWonAward;
        this.country = country;
        this.wines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return this.expertise;
    }

    public int getAge() {
        return age;
    }

    public boolean hasWonAward() {
        return hasWonAward;
    }

    public String getCountry() {
        return country;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public void addWine(Wine wine) {
        if (wines == null) {
            wines = new ArrayList<>();
        }
        wines.add(wine);
    }

    public Wine getWine(String name) {
        return wines.stream()
                .filter(wine -> wine.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void recommendWine(String food) {
        wines.stream()
                .filter(wine -> wine.getFoodPairing().equals(food))
                .forEach(wine -> System.out.println(
                        "I recommend the " + wine.getName() + " wine with your " + food +
                                " dish."));
    }

    public static void addWines(List<Sommelier> sommeliers, List<Wine> wines) {
        Random random = new Random();
        sommeliers.stream().forEach(sommelier -> {
            int randomIndex = random.nextInt(wines.size());
            sommelier.addWine(wines.get(randomIndex));
        });
    }
}