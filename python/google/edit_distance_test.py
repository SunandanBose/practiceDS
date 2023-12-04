import unittest
from edit_distance import EditDistance
class TestEditDistance(unittest.TestCase):
    def test_case_1(self):
        word1 = 'abcd'
        word2 = 'abdd'
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 1)
        
    def test_case_2(self):
        word1 = 'abcd'
        word2 = 'poor'
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 4)    
        
    def test_case_3(self):
        word1 = 'abcd'
        word2 = ''
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 4)
        
    def test_case_4(self):
        word1 = 'abud$'
        word2 = ''
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 5)    
        
    def test_case_5(self):
        word1 = 'intention'
        word2 = 'execution'
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 5)    
        
    def test_case_6(self):
        word1 = 'dinitrophenylhydrazine'
        word2 = 'benzalphenylhydrazone'
        e = EditDistance()
        result = e.calculateNumberOfChanges(word1, word2)
        self.assertEqual(result, 7)
        
if __name__ == '__main__':
    unittest.main()