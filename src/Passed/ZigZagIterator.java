package Passed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagIterator {
	Queue<Iterator<Integer>> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator<Integer>>();
        if(!v1.isEmpty()) queue.add(v1.iterator());
        if(!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int res = (int)iter.next();
        if(iter.hasNext()) queue.add(iter);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
