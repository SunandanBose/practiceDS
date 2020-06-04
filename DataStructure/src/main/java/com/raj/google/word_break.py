class Node:
    def __init__(self, isWordEnding=False):
        self.dictionary = {}
        self.isWordEnding = isWordEnding

class Trie:
    def __init__(self):
        self.node = Node()

    def add(self, word):
        wordToInsert = word
        currentNode = self.node
        while len(wordToInsert) > 0:
            currentDict = currentNode.dictionary
            char = wordToInsert[:1]
            if char in currentDict:
                currentNode = currentDict[char]
            else: 
                currentDict[char] = Node()
                currentNode = currentDict[char]
            wordToInsert = wordToInsert[1:]
        currentNode.isWordEnding = True

    def isWordPresent(self, word):
        wordToFind = word
        currentNode = self.node
        while len(wordToFind) > 0:
            currentDict = currentNode.dictionary
            char = wordToFind[:1]
            if char in currentDict:
                currentNode = currentDict[char]
                wordToFind = wordToFind[1:]
            else: return False
        
        return currentNode.isWordEnding

class Solution:
    def __init__:
        self.dict = {}

    def word_break(self, stringToSegment, dictionary):
        trie = Trie()
        [ trie.add(word) for word in dictionary ]
        return self.checkIfPossible(stringToSegment, trie)
        
    def checkIfPossible(self, word, trie):
        currentNode = trie.node
        index = 0
        if word == '':
            return True
        while index < len( word ):
            if word[index] in currentNode.dictionary:
                currentNode = currentNode.dictionary[word[index]]
                index = index + 1
                if currentNode.isWordEnding:
                    isPossible = self.checkIfPossible(word[index:], trie)
                    if isPossible:
                        return True
            else: break
        return False

print(Solution().word_break('myinterviewtrainer', ['trainer', 'my', 'interview']))

