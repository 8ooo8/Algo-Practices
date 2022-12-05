/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {
    TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> overlapped1 = bookings.floorEntry(start);
        Map.Entry<Integer, Integer> overlapped2 = bookings.lowerEntry(end);
        if ((overlapped2 != null && overlapped2.getValue() > start) || (overlapped1 != null && overlapped1.getValue() > start))
            return false;
        bookings.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end
