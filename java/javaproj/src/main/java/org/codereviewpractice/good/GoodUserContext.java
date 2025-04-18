package org.codereviewpractice.good;

import java.util.List;
import java.util.Set;

public record GoodUserContext(
        String role,
        boolean shouldLog,
        List<String> enrichmentKeys,
        Set<String> enrichmentSource,
        GoodEnrichmentMode enrichmentMode
) {}
