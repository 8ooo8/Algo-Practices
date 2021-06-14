function spiralTraverse(arr) {
    // Write your code here.
    const visited = arr.map(_ => Array(arr[0].length).fill(false));
    const spiralArr = [];
    const DFS = (row, col, direction) => {
        if (arr[row]?.[col] === undefined || visited[row][col])
            return false;
        spiralArr.push(arr[row][col]);
        visited[row][col] = true;
        const directions = [() => DFS(row, col + 1, 0), () => DFS(row + 1, col, 1),
            () => DFS(row, col - 1, 2), () => DFS(row - 1, col, 3)];
        [direction, direction + 1, direction + 2, direction + 3]
            .map(d => d % 4)
            .some(d => directions[d]());
        return true;
    };
    DFS(0, 0, 0);
    return spiralArr;
}

// Do not edit the line below.
exports.spiralTraverse = spiralTraverse;
