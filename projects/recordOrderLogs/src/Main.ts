/**
 * Problem:
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 *     record(order_id): adds the order_id to the log
 *     get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 *
 * Bonus:
 * You should be as efficient with time and space as possible.
 */

class OrderLog
{
    private log: number[];
    private maxSize: number;

    public constructor(N: number)
    {
        this.log = [];
        this.maxSize = N;
    }

    public record(order_id: number): void
    {
        this.log.push(order_id);
        if (this.log.length > this.maxSize)
        {
            this.log.shift();
        }
    }

    public get_last(index: number = 1): number
    {
        return this.log[this.log.length - index];
    }
}

console.log("Testing OrderLog...");
const log = new OrderLog(3);
log.record(1);
log.record(2);
log.record(4);
log.record(3);
console.log(log.get_last());
console.log(log.get_last(2));