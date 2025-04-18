from pyproj.good.good_constants import ProcessingMode


def is_unknown(item, known_items):
    return item not in known_items


def transform_item(item, mode: ProcessingMode):
    return item if mode == ProcessingMode.NORMAL else item[::-1]


def filter_and_transform(items, known_items, mode: ProcessingMode):
    return [
        transform_item(item, mode)
        for item in items
        if is_unknown(item, known_items)
    ]
