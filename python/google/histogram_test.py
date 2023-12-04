import sys
import unittest
import logging
from histogram import Histogram
class TestHistogram(unittest.TestCase):

    def test_case1(self):
        h = Histogram([1,3,4,2,5])
        h.display()
        self.assertEqual(h.calculateMaxAreaON(), 8)

    def test_case2(self):
        h = Histogram([2,1,2])
        self.assertEqual(h.calculateMaxAreaON(), 3)

if __name__ == '__main__':
    argv = len(sys.argv) > 1 and sys.argv[1]
    loglevel = logging.INFO if argv == '-v' else logging.WARNING
    logging.basicConfig(level=loglevel)
    unittest.main() 
