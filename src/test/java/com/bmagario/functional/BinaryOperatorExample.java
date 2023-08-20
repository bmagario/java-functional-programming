package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;

public class BinaryOperatorExample {

    @Test
    void unaryOperator() throws IOException {
        List<Wine> wines = JsonMockData.getWines();

        Wine mostExpensiveWine = wines.stream()
                .reduce(getWineWithHighestPrice)
                .get();

        System.out.println("The most expensive wine is " + mostExpensiveWine.getName()
                + " and it costs " + mostExpensiveWine.getPrice() + " USD.");
    }

    private BinaryOperator<Wine> getWineWithHighestPrice = (wine1, wine2) ->
            wine1.getPrice() > wine2.getPrice() ? wine1 : wine2;
}
