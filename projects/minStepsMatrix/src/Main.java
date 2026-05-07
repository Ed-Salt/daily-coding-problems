import java.util.ArrayDeque;
import java.util.Queue;

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

public class Main
{
    public static void main(String[] args)
    {
        boolean[][] board =
        {
            { false, false, false, false },
            { true, true, false, true },
            { false, false, false, false },
            { false, false, false, false }
        };
        int[] start = { 3, 0 };
        int[] end = { 0, 0 };
        Integer steps = minSteps(board, start, end);
        System.out.println(steps); // Output: 7

        boolean[][] board2 =
        {
            { false, false, false, false },
            { true, true, true, true },
            { false, false, false, false },
            { false, false, false, false }
        };
        Integer steps2 = minSteps(board2, start, end);
        System.out.println(steps2); // Output: null

        boolean[][] board3 =
        {
            { false, false, false, false, false },
            { true, true, true, true, false },
            { false, false, false, false, false },
            { false, true, true, true, true },
            { false, false, false, false, false }
        };
        int[] start3 = { 4, 4 };
        int[] end3 = { 0, 0 };
        Integer steps3 = minSteps(board3, start3, end3);
        System.out.println(steps3); // Output: 16
    }

    public static Integer minSteps(boolean[][] board, int[] start, int[] end)
    {
        int rows = board.length;
        int cols = board[0].length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Up, Down, Left, Right
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty())
        {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            if (row == end[0] && col == end[1]) { return steps; }

            for (int[] direction : directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                boolean isMoveWithinBounds = newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
                if (isMoveWithinBounds && !board[newRow][newCol] && !visited[newRow][newCol])
                {
                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol, steps + 1 });
                }
            }
        }

        return null;
    }
}