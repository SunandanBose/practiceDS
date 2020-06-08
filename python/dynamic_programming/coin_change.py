coins = []
amount = 25

class CoinChange:
    def __init__(self):
        None

    def get_coins(self, coins, amount):
        return []

    def count(self, coins, amount):
        return self.__count(coins, amount, 0)

    def __count(self, coins, amount, index):
        if amount < 0:
            return 0
        if amount == 0:
            return 1
        if (index == len(coins) and amount is not 0):
            return 0
        return self.__count(coins, amount - coins[index], index) + self.__count(coins, amount, index + 1)