export function badFilter(items: string[], knownItems: Set<string>, flag: boolean): string[] {
    let filtered: string[] = [];
    for (let item of items) {
        if (!knownItems.has(item)) {
            if (flag) {
                filtered.push(item);
            } else {
                filtered.push(item.split('').reverse().join(''));
            }
        }
    }
    return filtered;
}

