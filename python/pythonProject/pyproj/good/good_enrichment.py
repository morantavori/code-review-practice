from pyproj.good.good_constants import EnrichmentMode


def apply_enrichment(keys, reference_data, user_role, enrichment_mode: EnrichmentMode):
    enriched = {}
    for key in keys:
        if key in reference_data:
            enriched[key] = _enrich_item(key, enrichment_mode)
        elif user_role == 'admin':
            enriched[key] = 999
    return enriched


def _enrich_item(key, enrichment_mode: EnrichmentMode):
    if enrichment_mode == EnrichmentMode.DOUBLE:
        return len(key) * 2
    return len(key) + 2
