package com.ng.math;

public class LCM {
	
	//The least common multiple (LCM) of two numbers is the lowest possible number that can be divisible by both numbers
	
	public int findLCM (int a, int b) {
    
        int ans = (a > b) ? a : b;

      
        while (!((ans % a) == 0 && (ans % b) == 0)) {
            
            ans++;  // increment one by one
        }

        return ans;
        
    }
	
	//We know LCM(a, b) = (a x b) / GCD(a, b);
	//Time Complexity: O(log(min(a,b))
	
	public int findEfficientlyLCM (int a, int b) {
	    
       int ans = (a * b) / GCD.euclideanGCDEfficient(a, b);
        
       return ans;
        
    }

}
