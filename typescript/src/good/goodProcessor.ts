import { filterItems } from './goodFilter';
import { aggregateCounts } from './goodAggregator';
import { countProcessed } from './goodCounter';
import { logItems } from './goodLogger';
import { enrichResults, EnrichmentContext } from './goodEnricher';
import { ProcessingResult } from './goodGlobals';

export function processItems(
    items: string[],
    knownItems: Set<string>,
    mode: 'normal' | 'reverse',
    shouldLog: boolean
): ProcessingResult {
    const filtered = filterItems(items, knownItems, mode);
    const counts = new Map<string, number>();
    aggregateCounts(filtered, counts);
    const totalProcessed = countProcessed(filtered);
    logItems(filtered, shouldLog);
    return {
        filteredItems: filtered,
        counts,
        totalProcessed,
    };
}

export function applyEnrichment(
    baseResults: Map<string, number>,
    context: EnrichmentContext
): Map<string, number> {
    return enrichResults(baseResults, context);
}
