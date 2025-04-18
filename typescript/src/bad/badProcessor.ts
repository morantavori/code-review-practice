import { badFilter } from './badFilter';
import { badAggregator } from './badAggregator';
import { badCounter } from './badCounter';
import { badEnricher } from './badEnricher';
import { badLogger } from './badLogger';
import { results, counter } from './badGlobals';

export function badProcessor(
    items: string[],
    flag: boolean,
    knownItems: Set<string>,
    add1: string[],
    add2: Set<string>,
    log: boolean,
    user: string
): Map<string, number> {
    const filtered = badFilter(items, knownItems, flag);
    badAggregator(filtered, results);
    badCounter(filtered);
    badLogger(filtered, log);
    badEnricher(add1, add2, flag, user);
    return results;
}
