/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 */

// @lc code=start
class Solution {
    int largestSize;
    int factor;

    public int largestComponentSize(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] set = new int[nums.length];
        int[] size = new int[nums.length];

        // init
        int largestNum = 0;
        for (int i = 0; i < nums.length; i++) {
            set[i] = i;
            size[i] = 1;
            largestNum = Math.max(largestNum, nums[i]);
        }
        factor = 1;
        largestSize = 1;
        int factorUpLimit = largestNum / 2;
        
        // get the result
        while (largestSize < nums.length && factor <= factorUpLimit) {
            Set<Integer> toConnect = new HashSet<>();
            setNextFactor();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % factor == 0) {
                    toConnect.add(findRoot(set, i));
                }
            }

            List<Integer> toConnectList = new ArrayList(toConnect);
            for (int i = 0; i < toConnectList.size(); i++) {
                for (int j = i + 1; j < toConnectList.size(); j++) {
                    union(set, size, toConnectList.get(i), toConnectList.get(j));
                }
            }
        }

        return largestSize;
    }

    void setNextFactor() {
        switch (factor) {
            case 1: 
                factor = 2;
                break;
            case 2:
                factor = 3;
                break;
            default:
                factor += 2;
                break;
        }
    }

    int findRoot(int[] set, int i) {
        if (set[i] == i) return i;
        int root = findRoot(set, set[i]);
        set[i] = root; // path compression
        return root;
    }

    void union(int[] set, int[] size, int a, int b) {
        int aRoot = findRoot(set, a);
        int bRoot = findRoot(set, b);

        if (aRoot == bRoot)
            return;

        if (size[aRoot] > size[bRoot]) {
            set[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
            largestSize = Math.max(size[aRoot], largestSize);
        } else {
            set[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
            largestSize = Math.max(size[bRoot], largestSize);
        }
    }
}
// @lc code=end
