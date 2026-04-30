/**
 * Problem#20:
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Bonus:
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

function findNodeIntersect(listA: number[], listB: number[]): number | null
{
    const end = Math.min(listA.length, listB.length);
    let intersectingNode: number | null = null;

    for (let i = 0; i < end; i++)
    {
        const nodeA = listA[(listA.length - 1) - i];
        const nodeB = listB[(listB.length - 1) - i];

        if (nodeA === nodeB) { intersectingNode = nodeA; }
        else { break; }
    }
    return intersectingNode;
}

// Example usage:
const listA = [3, 7, 8, 10];
const listB = [99, 1, 8, 10];
const intersectingNode = findNodeIntersect(listA, listB);
console.log(intersectingNode); // Output: 8

const listC = [1, 2, 3];
const listD = [4, 5, 6];
const noIntersectingNode = findNodeIntersect(listC, listD);
console.log(noIntersectingNode); // Output: null

const listE = [1, 2, 3, 4, 5, 6];
const listF = [7, 8, 1, 3, 4, 5, 6];
const intersectingNodeMisMatch = findNodeIntersect(listE, listF);
console.log(intersectingNodeMisMatch); // Output: 3
