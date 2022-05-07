/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function(pushed, popped) {
    const stack = [];
    let i = 0;
    for (const pu of pushed)
    {
        stack.push(pu);
        while (stack.length && stack[stack.length - 1] === popped[i])
        {
            stack.pop();
            i++;
        }
    }
    return popped.length === i
};
