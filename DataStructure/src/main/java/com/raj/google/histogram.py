import logging
logger = logging.getLogger(__name__)

class Histogram:
    def __init__(self, histogram):
        self.values = histogram
    
    def display(self):
        max_value = max(self.values)
        for value in self.values:
            logger.info (value * "#")

    def calculateMaxAreaON(self):
        stack = []
        maxValue = -1
        for index, value in enumerate(self.values):
            # Insert in empty stack or insert if current value is greater than previous value
            # import pdb; pdb.set_trace()
            if not stack or (self.values[stack[len(stack) - 1]] <= value):
                logger.info('insertion in empty or upwards stack')
                stack.append(index)
                logger.info(stack)
                continue
            top = len(stack) - 1
            # pop until stack is empty or stack top is less than value
            # import pdb; pdb.set_trace()
            while stack and self.values[stack[top]] > value:
                # Pop the top most index of stack and get its value
                currentPoppedValue = self.values[stack.pop()]
                top = len(stack) - 1
                if not stack:
                    logger.info('empty stack processing')
                    # This is true because you cannot have a value lower than the current value so far with all elements
                    # Examples: 2,3,4,1,3
                    # So for 1 is obviously inclusive of all.
                    # When we put 3 it will never come here :D
                    currentValue = currentPoppedValue * index
                    maxValue = maxValue if maxValue > currentValue else currentValue
                else: 
                    logger.info('processing stack with values')
                    # Examples: 2,3,4,1,3
                    # We do index - 1 because when we popped 4
                    # The first iteration we want all values from index of 4 which is 3 upto index of 2 excluding 2
                    # Next iteration popped value is 3 we. We know all values from the popped element's index to the 
                    # current index is greater than popped value. i.e. That is how we have been putting the values
                    # The same logic applies above because that's how we did things earlier
                    currentValue = currentPoppedValue * (index - 1 - stack[top])
                    maxValue = maxValue if maxValue > currentValue else currentValue
            # push value either on empty stack or because value is greater than or equal to stack top
            stack.append(index)
            logger.info(stack)
        index = index + 1
        while stack:
            logger.info('overflow values for stack')
            # Pop the top most index of stack and get its value
            currentPoppedValue = self.values[stack.pop()]
            top = len(stack) - 1
            if not stack:
                currentValue = currentPoppedValue * index

                maxValue = maxValue if maxValue > currentValue else currentValue
            else: 
                currentValue = currentPoppedValue * (index - 1 - stack[top])

                maxValue = maxValue if maxValue > currentValue else currentValue
        return maxValue
