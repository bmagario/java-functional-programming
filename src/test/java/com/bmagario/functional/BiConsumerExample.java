package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class BiConsumerExample {

    @Test
    void biConsumer() throws IOException {
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();
        List<Wine> wines = JsonMockData.getWines();
        Sommelier.addWines(sommeliers, wines);

        sommeliers.stream()
                .flatMap(sommelier -> wines.stream()
                        .filter(wine -> sommelier.getWines().contains(wine))
                        .map(wine -> (Consumer<Wine>) recommendedWine -> printWineRecommendation.accept(
                                sommelier, recommendedWine)))
                .forEachOrdered(consumer -> wines.forEach(consumer));
    }

    private BiConsumer<Sommelier, Wine> printWineRecommendation = (sommelier, wine) ->
            System.out.println(
                    wine.getName() + " is recommended by " + sommelier.getName());
}
