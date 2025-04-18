from collections import Counter


def count_items(existing_counts, new_items):
    counter = Counter(new_items)
    for key, value in counter.items():
        existing_counts[key] = existing_counts.get(key, 0) + value
    return existing_counts
