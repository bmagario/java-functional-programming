package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class UnaryOperatorExample {

    @Test
    void unaryOperator() throws IOException {
        List<Wine> wines = JsonMockData.getWines();

        List<Wine> discountedWines = wines.stream()
                .map(applyDiscount)
                .collect(Collectors.toList());

        discountedWines.forEach(wine ->
                System.out.println(wine.getName() + " is now " + wine.getPrice() + " USD.")
        );
    }

    private UnaryOperator<Wine> applyDiscount = wine -> {
        wine.setPrice(wine.getPrice() * 0.9);
        return wine;
    };
}
