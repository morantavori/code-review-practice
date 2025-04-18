package org.codereviewpractice.good;

import java.util.List;
import java.util.Map;

public record GoodProcessingResult(
        List<String> filteredItems,
        Map<String, Integer> counts,
        int totalProcessed
) {}
