'''
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
'''

def min_rooms(intervals: list[tuple[int, int]]) -> int:
    if not intervals:
        return 0

    starts = sorted([start for start, end in intervals])
    ends = sorted([end for start, end in intervals])

    rooms = 0
    endIndex = 0

    for i in range(len(intervals)):
        if starts[i] < ends[endIndex]:
            rooms += 1
        else:
            endIndex += 1

    return rooms

# Example usage
intervals = [(30, 75), (0, 50), (60, 150)]
print(min_rooms(intervals))  # Output: 2

intervals2 = [(0, 30), (5, 20), (10, 15), (25, 40), (30, 35)]
print(min_rooms(intervals2))  # Output: 3

intervals3 = [(0, 10), (10, 20), (20, 30), (30, 40), (40, 50)]
print(min_rooms(intervals3))  # Output: 1