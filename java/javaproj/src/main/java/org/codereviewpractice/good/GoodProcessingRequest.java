package org.codereviewpractice.good;

import java.util.List;
import java.util.Set;

public record GoodProcessingRequest(
        List<String> items,
        Set<String> knownItems,
        GoodProcessingMode mode
) {}
