// Space: O(1)
function moveElementToEnd(arr, toMove) {
    // Write your code here.
    for (let i = 0, nextTargetIndex = arr.length - 1; i < nextTargetIndex;) {
        if (arr[i] === toMove) {
            [arr[i], arr[nextTargetIndex]] = [arr[nextTargetIndex], arr[i]];
            nextTargetIndex--;
        } else {
            i++;
        }
    }
    return arr;
}

// Do not edit the line below.
exports.moveElementToEnd = moveElementToEnd;
