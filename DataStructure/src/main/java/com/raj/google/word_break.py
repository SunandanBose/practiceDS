# {
#     r: {
#         keys: {
#             a: {
#                 keys: {
#                     m: {
#                         isWordEnd: True
#                     }
#                     j: {
#                         isWordEnd: True
#                         keys: {
#                             a: {
#                                 isWordEnd: True   
#                             }
#                         }
#                     }
#                 }
#             }
#         }
#     }
# }
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
        
trie = Trie()            
trie.add('ram')
print(trie.isWordPresent('ram'))
print(trie.isWordPresent('ra'))
print(trie.isWordPresent('rama'))
                
            
