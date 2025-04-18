package org.codereviewpractice.good;

import java.util.*;
import java.util.stream.Collectors;

public class GoodItemProcessor {

    public GoodProcessingResult processItems(final GoodProcessingRequest request) {
        final List<String> filteredItems = request.items().stream()
                .filter(item -> !request.knownItems().contains(item))
                .map(item -> request.mode() == GoodProcessingMode.REVERSE
                        ? new StringBuilder(item).reverse().toString()
                        : item)
                .toList();

        final Map<String, Integer> counts = filteredItems.stream()
                .collect(Collectors.toMap(
                        item -> item,
                        item -> 1,
                        Integer::sum
                ));

        return new GoodProcessingResult(filteredItems, counts, filteredItems.size());
    }

    public Map<String, Integer> enrichResults(
            final Map<String, Integer> baseResults,
            final GoodUserContext context
    ) {
        final Map<String, Integer> enriched = new HashMap<>(baseResults);

        context.enrichmentKeys().stream()
                .filter(Objects::nonNull)
                .forEach(key -> {
                    if (context.enrichmentSource().contains(key)) {
                        final int value = context.enrichmentMode() == GoodEnrichmentMode.DOUBLE
                                ? key.length() * 2
                                : key.length() + 2;
                        enriched.put(key, value);
                    } else if ("admin".equals(context.role())) {
                        enriched.put(key, 999);
                    }
                });

        return Map.copyOf(enriched); // safely return an immutable result
    }

    public void log(final List<String> items, final boolean shouldLog) {
        if (!shouldLog) return;
        System.out.printf("Processed items: %s%n", items);
    }
}
