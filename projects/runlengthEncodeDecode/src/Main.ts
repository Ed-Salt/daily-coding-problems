/** 
 * Problem:
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 *
 * Implement run-length encoding and decoding. 
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters. 
 * You can assume the string to be decoded is valid.
 */

function runLengthEncoding(input: string): string
{
    const strings: string[] = [];
    let count = 1;
    for (let i = 1; i <= input.length; i++)
    {
        const isLast = i === input.length;
        const current = isLast ? "" : input[i];
        const previous = input[i - 1];
        count = updateCount(count, current, previous, strings);
    }

    const encoded = strings.join("");
    return encoded;
}

function updateCount(count: number, current: string, previous: string, strings: string[]): number
{
    if (current === previous) { return count + 1; }
    strings.push(count.toString() + previous);
    return 1;
}

function runLengthDecoding(input: string): string
{
    const strings: string[] = [];
    for (let i = 0; i < input.length; i++)
    {
        let digitEnd = i;
        while (digitEnd < input.length && !isNaN(Number(input[digitEnd]))) { digitEnd++; }
        
        const count = parseInt(input.substring(i, digitEnd));
        const char = input[digitEnd];
        const string = char.repeat(count);
        strings.push(string);
        i = digitEnd;
    }

    const decoded = strings.join("");
    return decoded;
}

// Example usage:
const original = "AAAABBBCCDAA";
const encoded = runLengthEncoding(original);
console.log(`Encoded: ${encoded} \n ${encoded === "4A3B2C1D2A"}`);
const decoded = runLengthDecoding(encoded);
console.log(`Decoded: ${decoded} \n ${decoded === original}`);

const original2 = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB";
const encoded2 = runLengthEncoding(original2);
console.log(`Encoded: ${encoded2} \n ${encoded2 === "12W1B12W3B24W1B"}`);
const decoded2 = runLengthDecoding(encoded2);
console.log(`Decoded: ${decoded2} \n ${decoded2 === original2}`);

const original3 = "AABCCCDDD";
const encoded3 = runLengthEncoding(original3);
console.log(`Encoded: ${encoded3} \n ${encoded3 === "2A1B3C3D"}`);
const decoded3 = runLengthDecoding(encoded3);
console.log(`Decoded: ${decoded3} \n ${decoded3 === original3}`);

