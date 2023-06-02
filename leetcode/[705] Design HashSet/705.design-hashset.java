/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start
class MyHashSet {
    final int KEY_SPACE;
    Bucket[] buckets;

    public MyHashSet() {
        KEY_SPACE  = 769; // suggested to be a prime number to reduce the collision
        buckets = new Bucket[KEY_SPACE];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Bucket();
    }
    
    public void add(int key) {
        buckets[key % KEY_SPACE].add(key);
    }
    
    public void remove(int key) {
        buckets[key % KEY_SPACE].remove(Integer.valueOf(key)); // force it to call remove(Object o) instead of remove(int index)
    }
    
    public boolean contains(int key) {
        return buckets[key % KEY_SPACE].contains(key);
    }
}

// Better use red-black search tree instead of linked list
class Bucket extends LinkedList<Integer>{ // inheritance isn't a good approach here, as I didn't override all the methods that do insertion.
    public boolean add(Integer key) {
        if (!contains(key))
            return super.add(key);
        return false;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end
