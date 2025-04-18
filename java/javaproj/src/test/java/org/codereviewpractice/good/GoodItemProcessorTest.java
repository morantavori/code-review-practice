package org.codereviewpractice.good;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GoodItemProcessorTest {
    private GoodItemProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new GoodItemProcessor();
    }

    @Test
    void filtersAndCountsCorrectly() {
        final GoodProcessingRequest request = new GoodProcessingRequest(
                List.of("apple", "banana"),
                Set.of("apple"),
                GoodProcessingMode.NORMAL
        );

        final GoodProcessingResult result = processor.processItems(request);
        assertEquals(List.of("banana"), result.filteredItems());
        assertEquals(1, result.counts().get("banana"));
        assertEquals(1, result.totalProcessed());
    }

    @Test
    void reversesItemsWhenRequested() {
        final GoodProcessingRequest request = new GoodProcessingRequest(
                List.of("dog"),
                Set.of(),
                GoodProcessingMode.REVERSE
        );

        final GoodProcessingResult result = processor.processItems(request);
        assertEquals(List.of("god"), result.filteredItems());
    }

    @Test
    void adminGetsOverrideMetadata() {
        final GoodUserContext context = new GoodUserContext(
                "admin",
                false,
                List.of("ghost"),
                Set.of(),
                GoodEnrichmentMode.STANDARD
        );

        final Map<String, Integer> enriched = processor.enrichResults(Map.of(), context);
        assertEquals(999, enriched.get("ghost"));
    }

    @Test
    void enrichmentUsesLengthTransform() {
        final GoodUserContext context = new GoodUserContext(
                "user",
                false,
                List.of("cat"),
                Set.of("cat"),
                GoodEnrichmentMode.DOUBLE
        );

        final Map<String, Integer> enriched = processor.enrichResults(Map.of(), context);
        assertEquals(6, enriched.get("cat"));
    }
}
