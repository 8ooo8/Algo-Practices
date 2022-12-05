/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int)(((long)getMaxSideAfterCut(h, horizontalCuts) * (long)getMaxSideAfterCut(w, verticalCuts)) % 1000_000_007L);
    }

    private int getMaxSideAfterCut(int sideLenWithNoCut, int[] cuts) {
        int maxSideAfterCut = 0;
        int prevCutPosition = 0;
        for (int i = 0; i < cuts.length; i++) {
            maxSideAfterCut = Math.max(maxSideAfterCut, cuts[i] - prevCutPosition);
            prevCutPosition = cuts[i];
        }
        maxSideAfterCut = Math.max(maxSideAfterCut, sideLenWithNoCut - prevCutPosition);
        return maxSideAfterCut;
    }
}
// @lc code=end
