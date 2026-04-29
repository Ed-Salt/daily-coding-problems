'''
Problem:
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus:
Can you do this in one pass?
'''

def twoSum(nums: list[int], k: int) -> bool:
    for num in nums:
        if (k - num) in nums:
            return True
    return False

print(twoSum([10, 15, 3, 7], 17))