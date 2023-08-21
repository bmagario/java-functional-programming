package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class BiPredicatorExample {

    @Test
    void biPredicator() throws IOException {
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();
        List<Wine> wines = JsonMockData.getWines();
        Sommelier.addWines(sommeliers, wines);


        List<Wine> recommendedWines = wines.stream()
                .filter(wine -> isWineRecommendedByAnySommelierWithPriceLessThan.test(wine,
                        sommeliers))
                .collect(Collectors.toList());

        recommendedWines.forEach(wine ->
                System.out.println(wine.getName() +
                        " is recommended by any of the sommeliers and costs less than 95 USD.")
        );
    }

    private BiPredicate<Wine, List<Sommelier>> isWineRecommendedByAnySommelierWithPriceLessThan =
            (wine, sommeliers) -> sommeliers.stream()
                    .filter(sommelier -> sommelier.getWines() != null)
                    .anyMatch(sommelier -> sommelier.getWines().contains(wine) &&
                            wine.getPrice() < 95);

}
