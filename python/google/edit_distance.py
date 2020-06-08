class EditDistance:
    def __init__(self):
        self.bra = {}
        
    def calculateNumberOfChanges(self, word1, word2):
        key = word1+word2
        if key in self.bra:
            return self.bra[key]
        if not word1 and not word2:
            return 0
        if word1 and not word2:
            return len(word1)
        if not word1 and word2:
            return len(word2)
        if word1[0] == word2[0]:
            return self.calculateNumberOfChanges(word1[1:], word2[1:])
        insert = 1 + self.calculateNumberOfChanges(word1, word2[1:])
        update = 1 + self.calculateNumberOfChanges(word1[1:], word2[1:])
        delete = 1 + self.calculateNumberOfChanges(word1[1:], word2)
        result = min(insert, update, delete)
        self.bra[key] = result
        return result