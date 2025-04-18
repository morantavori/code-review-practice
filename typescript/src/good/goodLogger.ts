export function logItems(items: string[], shouldLog: boolean): void {
    if (shouldLog) {
        console.log('Processed items: ' + items);
    }
}
