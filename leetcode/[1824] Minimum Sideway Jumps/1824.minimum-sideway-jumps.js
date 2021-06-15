/**
 * @param {number[]} obstacles
 * @return {number}
 */
var minSideJumps = function(obstacles) {
    obstacles = obstacles.map(o => o - 1);
    let minJumps = [1, 0, 1];
    obstacles.forEach((o, i) => {
        if (o < 0) {
            minJumps[0] = Math.min(minJumps[0], Math.min(minJumps[1], minJumps[2]) + 1);
            minJumps[1] = Math.min(minJumps[1], Math.min(minJumps[0], minJumps[2]) + 1);
            minJumps[2] = Math.min(minJumps[2], Math.min(minJumps[1], minJumps[0]) + 1);
        } else {
            [o + 1, o + 2].map(lane => lane % 3)
                .forEach(lane => {
                    if (!isNaN(obstacles[i - 1]) && obstacles[i - 1] !== lane)
                        minJumps[lane] = Math.min(minJumps[lane], minJumps[o] + 1);
                });
            minJumps[o] = Number.MAX_SAFE_INTEGER;
        }
    });
    return minJumps.filter(m => m < Number.MAX_SAFE_INTEGER).reduce((min, jumps) => Math.min(min, jumps));
};
