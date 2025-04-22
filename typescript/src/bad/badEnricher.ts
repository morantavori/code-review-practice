export function badEnricher(add1: string[], add2: Set<string>, flag: boolean, user: string): void {
    for (let key of add1) {
        if (add2.has(key)) {
            if (flag) {
                results.set(key, key.length * 2);
            } else {
                results.set(key, key.length + 2);
            }
        } else {
            if (user === 'admin') {
                results.set(key, 999);
            }
        }
    }
}

