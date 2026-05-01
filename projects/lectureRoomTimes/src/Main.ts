/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

function minRooms(intervals: [number, number][]): number
{
    const length = intervals.length;
    if (length === 0) { return 0; }

    const starts = intervals.map(([start]) => start).sort((a, b) => a - b);
    const ends = intervals.map(([, end]) => end).sort((a, b) => a - b);

    let rooms = 0;
    let endIndex = 0;

    for (let i = 0; i < length; i++)
    {
        if (starts[i] < ends[endIndex]) { rooms++; }
        else { endIndex++; }
    }

    return rooms;
}

// Example usage:
const intervals: [number, number][] = [[30, 75], [0, 50], [60, 150]];
console.log(minRooms(intervals)); // Output: 2

const intervals2: [number, number][] = [[0, 30], [5, 20], [10, 15], [25, 40], [30, 35]];
console.log(minRooms(intervals2)); // Output: 3

const intervals3: [number, number][] = [[0, 10], [10, 20], [20, 30], [30, 40], [40, 50]];
console.log(minRooms(intervals3)); // Output: 1