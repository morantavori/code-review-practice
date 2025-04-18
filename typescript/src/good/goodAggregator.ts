export function aggregateCounts(filtered: string[], results: Map<string, number>): void {
    filtered.forEach(item => results.set(item, (results.get(item) || 0) + 1));
}
