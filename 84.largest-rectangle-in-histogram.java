/*
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (28.31%)
 * Total Accepted:    128.2K
 * Total Submissions: 452.8K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	int len = heights.length;
    	int maxArea = 0;
    	if (len == 0) return maxArea;
    	
    	int[] lessFromLeft = new int[len];
    	int[] lessFromRight = new int[len];
    	lessFromLeft[0] = -1;
    	lessFromRight[len-1] = len;

    	for(int i=1; i<len; i++) {
    		int j = i-1;
    		while (j>=0) {
    			if (heights[j] < heights[i]) {
    				lessFromLeft[i] = j;
    				break;
    			} else {
    				lessFromLeft[i] = lessFromLeft[j];
    			}
    			j--;
    		}
    	}
    	for(int i=len-2; i>=0; i--) {
    		int j = i+1;
    		while (j<len){
    			if (heights[j] < heights[i]) {
    				lessFromRight[i] = j;
    				break;
    			} else {
    				lessFromRight[i] = lessFromRight[j];
    			}
    			j++;
    		}
    	}

    	for(int i=0; i<len; i++) maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i]-lessFromLeft[i]-1));
        return maxArea;
    }
}
