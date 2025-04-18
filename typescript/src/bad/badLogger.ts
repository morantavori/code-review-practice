export function badLogger(stuff: string[], should: boolean): void {
    if (should) {
        console.log('Did stuff with: ' + stuff);
    }
}
