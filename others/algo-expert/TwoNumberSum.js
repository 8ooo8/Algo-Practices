function twoNumberSum(array, targetSum) {
  // Write your code here.
    const result = [];
    for (let i = 0; i < array.length - 1; i++) {
        for (let j = i + 1; j < array.length; j++) {
            if (array[i] + array[j] === targetSum)
                result.push(array[i], array[j]);
        }
    }
    return result;
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;
