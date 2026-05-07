/**
 * You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 *
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
 *
 * For example, given the following board:
 *
 * [
 *      [f, f, f, f],
 *      [T, T, f, T],
 *      [f, f, f, f],
 *      [f, f, f, f]
 * ]
 *
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

function minSteps(board: boolean[][], start: [number, number], end: [number, number]): number | null
{
    const rows = board.length;
    const cols = board[0].length;
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const visited = new Set<string>();
    const queue: [number, number, number][] = [[start[0], start[1], 0]]; // [row, col, steps]

    while (queue.length > 0)
    {
        const [row, col, steps] = queue.shift()!;

        if (row === end[0] && col === end[1]) { return steps; }

        visited.add(`${row},${col}`);

        for (const [dr, dc] of directions)
        {
            const newRow = row + dr;
            const newCol = col + dc;

            const isMoveWithinBounds = newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
            if (isMoveWithinBounds && !board[newRow][newCol] && !visited.has(`${newRow},${newCol}`))
            {
                queue.push([newRow, newCol, steps + 1]);
            }
        }
    }
    return null;
}

// Example usage:
const board =
[
    [false, false, false, false],
    [true, true, false, true],
    [false, false, false, false],
    [false, false, false, false]
];
const start: [number, number] = [3, 0];
const end: [number, number] = [0, 0];
console.log(minSteps(board, start, end)); // Output: 7

const noPathBoard =
[
    [false, false, false, false],
    [true, true, true, true],
    [false, false, false, false],
    [false, false, false, false]
];
console.log(minSteps(noPathBoard, start, end)); // Output: null

const largerBoard =
[
    [false, false, false, false, false],
    [true, true, true, true, false],
    [false, false, false, false, false],
    [false, true, true, true, true],
    [false, false, false, false, false]
];
const largerStart: [number, number] = [4, 4];
const largerEnd: [number, number] = [0, 0];
console.log(minSteps(largerBoard, largerStart, largerEnd)); // Output: 16