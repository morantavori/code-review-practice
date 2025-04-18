export function enrichResults(
    baseResults: Map<string, number>,
    context: EnrichmentContext
): Map<string, number> {
    const enriched = new Map(baseResults);
    context.enrichmentKeys.forEach(key => {
        if (context.enrichmentSource.has(key)) {
            enriched.set(key, context.enrichmentMode === 'double' ? key.length * 2 : key.length + 2);
        } else if (context.role === 'admin') {
            enriched.set(key, 999);
        }
    });
    return enriched;
}
