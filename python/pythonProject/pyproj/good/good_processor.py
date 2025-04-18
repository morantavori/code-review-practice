from pyproj.good.good_filtering import filter_and_transform
from pyproj.good.good_result_counter import count_items
from pyproj.good.good_enrichment import apply_enrichment
from pyproj.good.good_constants import ProcessingMode, EnrichmentMode


class ItemProcessor:
    def __init__(self):
        self.total_processed = 0
        self.results = {}

    def process_items(self, items, known_items, mode: ProcessingMode):
        self._log(f"processing items {items}")
        filtered = filter_and_transform(items, known_items, mode)
        self._increment_counter(len(filtered))
        count_items(self.results, filtered)
        return filtered

    def enrich_results(self, keys, reference_data, user_role, enrichment_mode: EnrichmentMode):
        enriched = apply_enrichment(keys, reference_data, user_role, enrichment_mode)
        self.results.update(enriched)

    def _increment_counter(self, count):
        self.total_processed += count

    def _log(self, message):
        print(f"[LOG]: {message}")
