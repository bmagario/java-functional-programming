package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class SupplierExample {

    @Test
    void supplier() {
        Wine randomWine = getRandomWine.get();

        System.out.println(randomWine.getName());
    }

    private Supplier<Wine> getRandomWine = () -> {
        List<Wine> wines;
        try {
            wines = JsonMockData.getWines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wines.get(new Random().nextInt(wines.size()));
    };
}
