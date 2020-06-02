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
                print (currentDict)
                currentDict[char] = Node()
                currentNode = currentDict[char]
            wordToInsert = wordToInsert[1:]
        currentNode.isWordEnding = True

            
Trie().add('ram')
                
            
