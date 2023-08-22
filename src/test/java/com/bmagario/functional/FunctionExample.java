package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

public class FunctionExample {

    @Test
    void function() throws IOException {
        List<Wine> wines = JsonMockData.getWines();

        wines.stream()
                .map(getWineDescription)
                .forEach(System.out::println);
    }

    private Function<Wine, String> getWineDescription = wine ->
            "This wine is a " + wine.getGrapeVariety() + " year " + wine.getYear() + ".";

}
