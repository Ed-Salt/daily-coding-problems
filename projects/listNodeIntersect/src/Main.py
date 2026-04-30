'''
 * Problem#20:
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Bonus:
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
'''

def findNodeIntersect(listA: list[int], listB: list[int]) -> int | None:
    end = min(len(listA), len(listB))
    intersectingNode: int | None = None
    for i in range(end):
        valA = listA[(len(listA) - 1) - i]
        valB = listB[(len(listB) - 1) - i]
        if valA == valB:
            intersectingNode = valA
        else:
            break
    return intersectingNode

print(findNodeIntersect([3, 7, 8, 10], [99, 1, 8, 10]))

print(findNodeIntersect([1, 2, 3], [4, 5, 6]))

print(findNodeIntersect([1, 2, 3, 4, 5, 6], [7, 8, 1, 3, 4, 5, 6]))