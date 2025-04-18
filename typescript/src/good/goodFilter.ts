export function filterItems(items: string[], knownItems: Set<string>, mode: 'normal' | 'reverse'): string[] {
    return items.filter(item => !knownItems.has(item)).map(item => mode === 'reverse' ? item.split('').reverse().join('') : item);
}
