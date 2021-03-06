package Passed;

import java.util.Iterator;
import java.util.List;

public class flatten2DVector {
	 	Iterator<List<Integer>> it;
	    Iterator<Integer> curr;
	    
	    public Vector2D(List<List<Integer>> vec2d) {
	        it = vec2d.iterator();
	    }

	    public int next() {
	        hasNext();
	        return curr.next();
	    }

	    public boolean hasNext() {
	        // 当前列表的迭代器为空，或者当前迭代器中没有下一个值时，需要更新为下一个迭代器
	        while((curr == null || !curr.hasNext()) && it.hasNext()){
	            curr = it.next().iterator();
	        }
	        return curr != null && curr.hasNext();
	    }

}
