// Time: O(nlog(n) + mlog(m))
function smallestDifference(arr1, arr2) {
    arr1.sort((a, b) => a - b);
    arr2.sort((a, b) => a - b);
    let minDiff = [Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY];
    let i1 = i2 = 0;
    while (i1 < arr1.length && i2 < arr2.length) {
        const num1 = arr1[i1], num2 = arr2[i2];
        minDiff = Math.abs(num1 - num2) < Math.abs(minDiff[0] - minDiff[1]) ? [num1, num2] : minDiff;
        if (num1 < num2) 
            i1++;
        else 
            i2++;
    }
    return minDiff;
}

// Brute force
// function smallestDifference(arrayOne, arrayTwo) {
  // // Write your code here.
    // let smallestDiff = [Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY];
    // arrayOne.forEach(num1 => arrayTwo.forEach(num2 =>{
        // smallestDiff = Math.abs(num1 - num2) < Math.abs(smallestDiff[0] - smallestDiff[1]) ? [num1, num2] : smallestDiff;
    // }));
    // return smallestDiff;
// }

// Do not edit the line below.
exports.smallestDifference = smallestDifference;
