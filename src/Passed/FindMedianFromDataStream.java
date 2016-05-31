package Passed;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	 public PriorityQueue<Integer> minheap, maxheap;
	    
	    public MedianFinder() {
	        minheap = new PriorityQueue<Integer>();
	        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
	    }
	    
	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        maxheap.add(num);
	        minheap.add(maxheap.poll());
	        
	        if(maxheap.size() < minheap.size()) {
	            maxheap.add(minheap.poll());
	        }
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if (maxheap.size() == minheap.size()) {
	            return (maxheap.peek() + minheap.peek()) * 0.5;
	        } else {
	            return maxheap.peek();
	        }
	    }
}
