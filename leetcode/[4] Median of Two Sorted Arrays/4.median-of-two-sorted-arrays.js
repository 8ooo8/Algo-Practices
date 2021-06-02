/*
 * @lc app=leetcode id=4 lang=javascript
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.23%)
 * Likes:    5873
 * Dislikes: 892
 * Total Accepted:    588.7K
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    return getMedian(nums1, nums2);
};

const getMedian = (nums1, nums2) => {
    const isMedian = (medianCandidate, leftNum, rightNum) => {
        if ([leftNum, rightNum].every(v => isNaN(v))) return false;
        if (leftNum > medianCandidate) return false;
        if (rightNum < medianCandidate) return false;
        return true;
    }
    
    const oddElements = (nums1.length + nums2.length) % 2;
    const getMedianByBinarySearch = (numsWithMedian, nums2, from, to) => {
        const middle = Math.floor((to - from) / 2) + from;
        let leftNumIdx, rightNumIdx, medianCandidateIdx, medianCandidate;


        if (oddElements) {
            medianCandidateIdx = middle;
            leftNumIdx = (numsWithMedian.length - 1 + nums2.length) / 2  - middle - 1;
            rightNumIdx = (numsWithMedian.length - 1 + nums2.length) / 2  - middle;
        } else {
            medianCandidateIdx = middle;
            leftNumIdx = (numsWithMedian.length - 2 + nums2.length) / 2 - middle - 1;
            rightNumIdx = (numsWithMedian.length - 2 + nums2.length) / 2 - middle;
        }
        medianCandidate = numsWithMedian[medianCandidateIdx];

        if (isMedian(medianCandidate, nums2[leftNumIdx], nums2[rightNumIdx])) {
            if (oddElements)
                return medianCandidate;
            let medianCandidates= [medianCandidateIdx + 1].map(i => {
                    const leftNum = nums2[(numsWithMedian.length - 2 + nums2.length) / 2 - middle - 1];
                    const rightNum = nums2[(numsWithMedian.length - 2 + nums2.length) / 2 - middle];
                    if (isMedian(numsWithMedian[i], leftNum, rightNum) || nums2.length == 1) return numsWithMedian[i];
                    });
            medianCandidates = medianCandidates.concat(
                [(numsWithMedian.length - 2 + nums2.length) / 2 - middle] .map(i => {
                    const leftNum = numsWithMedian[medianCandidateIdx - 1];
                    const rightNum = numsWithMedian[medianCandidateIdx + 1];
                    if (isMedian(nums2[i], leftNum, rightNum) || numsWithMedian.length == 1) return nums2[i];
                    }));
            return (medianCandidate + medianCandidates.filter(m => !isNaN(m)).sort()[0]) / 2;
        }
        if (to === from)
            return NaN;

        if ((medianCandidate < nums2[leftNumIdx] || leftNumIdx >= nums2.length) && middle + 1 <= to)
            return getMedianByBinarySearch(numsWithMedian, nums2, middle + 1, to);
        if ((medianCandidate > nums2[rightNumIdx] || rightNumIdx < 0) && middle - 1 >= from)
            return getMedianByBinarySearch(numsWithMedian, nums2, from, middle - 1);
    }

    if (nums1.length == 1 && nums2.length == 1)
        return (nums1[0] + nums2[0]) / 2;
    if (nums1.length == 0)
        return nums2.length % 2 ? nums2[Math.floor(nums2.length / 2)] : (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
    if (nums2.length == 0)
        return nums1.length % 2 ? nums1[Math.floor(nums1.length / 2)] : (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
    return getMedianByBinarySearch(nums1, nums2, 0, nums1.length - 1)
        || getMedianByBinarySearch(nums2, nums1, 0, nums2.length - 1);
}
// @lc code=end
