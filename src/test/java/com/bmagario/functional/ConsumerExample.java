package com.bmagario.functional;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class ConsumerExample {

    @Test
    void consumer() throws IOException {
        List<Wine> wines = JsonMockData.getWines();

        wines.stream()
                .forEach(printWineName);
    }

    private Consumer<Wine> printWineName = wine -> System.out.println(wine.getName());
}
