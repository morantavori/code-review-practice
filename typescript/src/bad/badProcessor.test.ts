import { badProcessor } from './badProcessor';

describe('badProcessor', () => {
    it('should process items correctly', () => {
        const items = ['apple', 'banana'];
        const knownItems = new Set(['apple']);
        const add1 = ['cherry'];
        const add2 = new Set(['cherry']);
        const log = true;
        const user = 'admin';

        const result = badProcessor(items, true, knownItems, add1, add2, log, user);
        expect(result.get('banana')).toBe(1);
        expect(result.get('cherry')).toBe(999);
    });
});
