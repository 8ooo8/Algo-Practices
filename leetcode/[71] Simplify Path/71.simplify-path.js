/*
 * @lc app=leetcode id=71 lang=javascript
 *
 * [71] Simplify Path
 */

// @lc code=start
/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    let chunks = path.split('/').filter(c => c);
    let directories = [];
    chunks.forEach(c => {
        if (c == '.')
            return;
        else if (c == '..')
            directories.pop();
        else
            directories.push(c);
    });
    return directories.length ? directories.reduce((simplifiedPath, directoryOrFile) => `${simplifiedPath}/${directoryOrFile}`, '') : '/';
};
// @lc code=end
