package Passed;

import java.util.List;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                res += nestedList.get(i).getInteger()*depth;
            } else {
                res += helper(nestedList.get(i).getList(), depth + 1);
            }
        }
        
        return res;
    }
}
