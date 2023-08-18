package com.bmagario.streams;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ComparatorExample {

    @Test
    void comparator() throws IOException {
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.sort(compareSommeliersByAge);

        sommeliers.forEach(
                sommelier -> System.out.println(sommelier.getName() + " is "
                        + sommelier.getAge() + " years old."));

    }

    public static Comparator<Sommelier> compareSommeliersByAge =
            Comparator.comparingInt(Sommelier::getAge);
}
