'''
Problem:
You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

Bonus:
You should be as efficient with time and space as possible.
'''

class OrderLog:
    def __init__(self, n):
        self.n = n
        self.log = []
    
    def record(self, order_id):
        if len(self.log) == self.n:
            self.log.pop(0)
        self.log.append(order_id)
    
    def get_last(self, i = 1):
        if i > len(self.log):
            return None
        return self.log[-i]

print("Example:")
order_log = OrderLog(5)
order_log.record(1)
order_log.record(2)
order_log.record(4)
order_log.record(3)
print(order_log.get_last())
print(order_log.get_last(2))