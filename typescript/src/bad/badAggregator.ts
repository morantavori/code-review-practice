export function badAggregator(filtered: string[], results: Map<string, number>): void {
    for (let item of filtered) {
        if (results.has(item)) {
            results.set(item, results.get(item)! + 1);
        } else {
            results.set(item, 1);
        }
    }
}
