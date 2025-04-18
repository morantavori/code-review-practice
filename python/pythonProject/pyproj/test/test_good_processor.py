import unittest
from pyproj.good.good_processor import ItemProcessor
from pyproj.good.good_constants import ProcessingMode, EnrichmentMode


class TestItemProcessor(unittest.TestCase):
    def setUp(self):
        self.processor = ItemProcessor()

    def test_process_items_reverse_mode(self):
        items = ['apple', 'banana']
        known = {'apple'}
        result = self.processor.process_items(items, known, ProcessingMode.REVERSE)
        self.assertIn('ananab', result)
        self.assertEqual(self.processor.results['ananab'], 1)

    def test_process_items_normal_mode(self):
        items = ['cat']
        known = {}
        result = self.processor.process_items(items, known, ProcessingMode.NORMAL)
        self.assertIn('cat', result)

    def test_enrich_admin_override(self):
        self.processor.enrich_results(
            keys=['unknown'],
            reference_data={},
            user_role='admin',
            enrichment_mode=EnrichmentMode.STANDARD
        )
        self.assertEqual(self.processor.results['unknown'], 999)

    def test_total_processed_counter(self):
        self.processor.process_items(['dog'], {}, ProcessingMode.REVERSE)
        self.assertEqual(self.processor.total_processed, 1)


if __name__ == '__main__':
    unittest.main()
