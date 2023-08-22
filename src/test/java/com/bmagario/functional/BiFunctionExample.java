package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

public class BiFunctionExample {

    @Test
    void biFunction() throws IOException {
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();
        List<Wine> wines = JsonMockData.getWines();
        Sommelier.addWines(sommeliers, wines);

        sommeliers.stream()
                .forEach(sommelier -> wines.stream()
                        .filter(wine -> sommelier.getWines().contains(wine))
                        .forEach(wine -> System.out.println(
                                getWineRecommendationString.apply(sommelier, wine))));
    }

    private BiFunction<Sommelier, Wine, String> getWineRecommendationString = (sommelier, wine)
            -> wine.getName() + " is recommended by " + sommelier.getName();
}
