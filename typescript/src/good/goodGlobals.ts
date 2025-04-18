export interface ProcessingResult {
    filteredItems: string[];
    counts: Map<string, number>;
    totalProcessed: number;
}

export interface EnrichmentContext {
    role: string;
    enrichmentKeys: string[];
    enrichmentSource: Set<string>;
    enrichmentMode: 'standard' | 'double';
}

export const results: Map<string, number> = new Map();
