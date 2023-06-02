/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
    int[] maxCars;
    int[] cars = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        maxCars = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (cars[carType - 1] >= maxCars[carType - 1])
            return false;
        ++cars[carType - 1];
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end
