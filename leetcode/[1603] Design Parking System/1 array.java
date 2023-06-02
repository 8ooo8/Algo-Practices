/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
    int[] available;

    public ParkingSystem(int big, int medium, int small) {
        available = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (available[carType - 1] <= 0)
            return false;
        --available[carType - 1];
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end
