/*
 * @lc app=leetcode id=359 lang=java
 *
 * [359] Logger Rate Limiter
 */

// @lc code=start
class Logger {
    Map<String, Integer> msgs;

    public Logger() {
        msgs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (msgs.getOrDefault(message, -10) + 10 > timestamp)
            return false;
        msgs.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// @lc code=end
