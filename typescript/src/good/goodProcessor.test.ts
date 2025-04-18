import { processItems, applyEnrichment } from './goodProcessor';
import { EnrichmentContext } from './goodGlobals';

describe('GoodProcessor', () => {
    it('filters and counts items correctly', () => {
        const result = processItems(['apple', 'banana'], new Set(['apple']), 'normal', false);
        expect(result.filteredItems).toEqual(['banana']);
        expect(result.counts.get('banana')).toBe(1);
        expect(result.totalProcessed).toBe(1);
    });

    it('reverses items when mode is reverse', () => {
        const result = processItems(['cat'], new Set(), 'reverse', false);
        expect(result.filteredItems).toEqual(['tac']);
    });

    it('applies enrichment for known keys', () => {
        const base = new Map<string, number>();
        const context: EnrichmentContext = {
            role: 'user',
            enrichmentKeys: ['hello'],
            enrichmentSource: new Set(['hello']),
            enrichmentMode: 'double'
        };

        const enriched = applyEnrichment(base, context);
        expect(enriched.get('hello')).toBe(10); // "hello".length * 2
    });

    it('applies admin override when key is unknown', () => {
        const base = new Map<string, number>();
        const context: EnrichmentContext = {
            role: 'admin',
            enrichmentKeys: ['secret'],
            enrichmentSource: new Set(),
            enrichmentMode: 'standard'
        };

        const enriched = applyEnrichment(base, context);
        expect(enriched.get('secret')).toBe(999);
    
