class CoinChange:
    def __init__(self):
        self._map = {}

    def get_coins(self, coins, amount):
        return []

    def count(self, amount, coins):
        return self.__count(coins, amount, 0)

    def __count(self, coins, amount, index):
        if amount < 0:
            return 0
        if amount == 0:
            return 1
        if (index == len(coins) and amount is not 0):
            return 0
        key = str(amount) + '@' + str(index)
        if key in self._map:
            return self._map[key]
        count = self.__count(coins, amount - coins[index], index) + self.__count(coins, amount, index + 1)
        self._map[key] = count
        return count