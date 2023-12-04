import unittest
from coin_change import CoinChange

class CoinChangeTest(unittest.TestCase):
    def test_coin_change_works(self):
        self.assertEqual(5, CoinChange().count([1,2,3], 5))

if __name__ == '__main__':
    unittest.main()