package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class PredicateExample {

    @Test
    void predicate() throws IOException {
        List<Wine> wines = JsonMockData.getWines();

        List<Wine> recommendedWines = wines.stream()
                .filter(isWineRecommendedByAnySommelier)
                .collect(Collectors.toList());

        recommendedWines.forEach(wine -> System.out.println(
                wine.getName() + " is recommended by any of the sommeliers."));
    }

    private Predicate<Wine> isWineRecommendedByAnySommelier = wine -> {
        List<Sommelier> sommeliers;
        try {
            sommeliers = JsonMockData.getSommeliers();
            Sommelier.addWines(sommeliers, List.of(wine));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sommeliers.stream()
                .anyMatch(sommelier -> sommelier.getWines().contains(wine) &&
                        wine.getPrice() < 100);
    };
}
