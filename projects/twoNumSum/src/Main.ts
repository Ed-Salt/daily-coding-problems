/**
 * Problem#1:
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus:
 * Can you do this in one pass?
 */

function twoSum(nums: number[], k: number): boolean
{
    for (const num of nums)
    {
        if (nums.includes(k - num)) { return true; }
    }
    return false;
}

console.log(twoSum([10, 15, 3, 7], 17));