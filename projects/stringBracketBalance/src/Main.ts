/**
 * Problem:
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

function isBalanced(input: string): boolean | null
{
    if (input.length === 0) { return true; }

    const isValid = /^[\(\)\[\]\{\}]+$/.test(input);
    if (!isValid) { return null; }

    const isEven = input.length % 2 === 0;
    if (!isEven) { return false; }

    const stack: string[] = [];
    const pairs: { [key: string]: string } =
    {
        ')': '(',
        ']': '[',
        '}': '{'
    }

    for (const char of input)
    {
        if (pairs[char])
        {
            if (stack.length === 0) { return false; }
            const lastOpen = stack.pop()!;
            if (lastOpen !== pairs[char]) { return false; }
        }
        else { stack.push(char); }
    }
    return stack.length === 0;
}

// Test cases
console.log(isBalanced("([])[]({})")); // true
console.log(isBalanced("([)]")); // false
console.log(isBalanced("")); // true
console.log(isBalanced("((()")); // false
console.log(isBalanced("((()))")); // true
console.log(isBalanced("([)]{}")); // false
console.log(isBalanced("({[a]})")); // null