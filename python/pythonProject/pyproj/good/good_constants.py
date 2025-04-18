from enum import Enum


class ProcessingMode(Enum):
    NORMAL = 'normal'
    REVERSE = 'reverse'


class EnrichmentMode(Enum):
    STANDARD = 'standard'
    DOUBLE = 'double'
